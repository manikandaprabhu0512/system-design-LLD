package Problems.MusicPlayerSystem;

import Problems.MusicPlayerSystem.core.AudioEngine;
import Problems.MusicPlayerSystem.device.IAudioOutputDevice;
import Problems.MusicPlayerSystem.enums.DeviceType;
import Problems.MusicPlayerSystem.enums.PlayStrategyType;
import Problems.MusicPlayerSystem.managers.DeviceManager;
import Problems.MusicPlayerSystem.managers.PlaylistManager;
import Problems.MusicPlayerSystem.managers.StrategyManager;
import Problems.MusicPlayerSystem.models.Playlist;
import Problems.MusicPlayerSystem.models.Song;
import Problems.MusicPlayerSystem.strategies.PlayStrategy;

public class MusicPlayerFacade {
    private static MusicPlayerFacade instance = null;
    private AudioEngine audioEngine;
    private Playlist loadedPlaylist;
    private PlayStrategy playStrategy;

    private MusicPlayerFacade() {
        loadedPlaylist = null;
        playStrategy = null;
        audioEngine = new AudioEngine();
    }

    public static synchronized MusicPlayerFacade getInstance() {
        if (instance == null) {
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    public void connectDevice(DeviceType deviceType) {
        DeviceManager.getInstance().connect(deviceType);
    }

    public void setPlayStrategy(PlayStrategyType strategyType) {
        playStrategy = StrategyManager.getInstance().getStrategy(strategyType);
    }

    public void loadPlaylist(String name) {
        loadedPlaylist = PlaylistManager.getInstance().getPlaylist(name);
        if (playStrategy == null) {
            throw new RuntimeException("Play strategy not set before loading.");
        }
        playStrategy.setPlayList(loadedPlaylist);
    }

    public void playSong(Song song) {
        if (!DeviceManager.getInstance().hasOutputDevice()) {
            throw new RuntimeException("No audio device connected.");
        }
        IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
        audioEngine.play(device, song);
    }

    public void pauseSong(Song song) {
        if (!audioEngine.getCurrentSongTitle().equals(song.getTitle())) {
            throw new RuntimeException("Cannot pause \"" + song.getTitle() + "\"; not currently playing.");
        }
        audioEngine.pause();
    }

    public void playAllTracks() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        while (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        }
        System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
    }

    public void playNextTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void playPreviousTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasPrev()) {
            Song prevSong = playStrategy.previous();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, prevSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void enqueueNext(Song song) {
        playStrategy.addNextSong(song);
    }
}
