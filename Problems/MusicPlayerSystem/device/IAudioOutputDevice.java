package Problems.MusicPlayerSystem.device;

import Problems.MusicPlayerSystem.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
