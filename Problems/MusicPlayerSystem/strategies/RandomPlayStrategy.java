package Problems.MusicPlayerSystem.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import Problems.MusicPlayerSystem.models.Playlist;
import Problems.MusicPlayerSystem.models.Song;

public class RandomPlayStrategy implements PlayStrategy{
    private Playlist currentPlaylist;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private Random random;

    public RandomPlayStrategy() {
        currentPlaylist = null;
        random = new Random();
    }

    @Override
    public void setPlayList(Playlist playlist) {
        this.currentPlaylist = playlist;
        if(currentPlaylist == null || currentPlaylist.getSize() == 0) return;

        remainingSongs = new ArrayList<>(currentPlaylist.getSongs());
        history = new Stack<>();
    }

    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }

        int idx = random.nextInt(remainingSongs.size());
        Song selectedSong = remainingSongs.get(idx);

        // Remove the selectedSong from the list. (Swap and pop to remove in O(1))
        int lastIndex = remainingSongs.size() - 1;
        remainingSongs.set(idx, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);

        history.push(selectedSong);
        return selectedSong;
    }
    
    @Override
    public boolean hasNext() {
        return currentPlaylist != null && remainingSongs.isEmpty();
    }

    @Override
    public Song previous() {
        if (history.isEmpty()) {
            throw new RuntimeException("No previous song available.");
        }

        Song song = history.pop();
        return song;
    }

    @Override
    public boolean hasPrev() {
        return history.size() > 0;
    }
    
}
