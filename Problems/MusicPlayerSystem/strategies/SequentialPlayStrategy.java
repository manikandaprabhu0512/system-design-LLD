package Problems.MusicPlayerSystem.strategies;

import Problems.MusicPlayerSystem.models.Playlist;
import Problems.MusicPlayerSystem.models.Song;

public class SequentialPlayStrategy implements PlayStrategy {
    private Playlist currentPlaylist;
    private int currentIndex;

    public SequentialPlayStrategy() {
        this.currentPlaylist = null;
        this.currentIndex = -1;
    }

    @Override
    public void setPlayList(Playlist playlist) {
        currentPlaylist = playlist;
        currentIndex = -1;
    }

    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex = currentIndex + 1;
        return currentPlaylist.getSongs().get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return ((currentIndex + 1) < currentPlaylist.getSize());
    }

    @Override
    public Song previous() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex = currentIndex - 1;
        return currentPlaylist.getSongs().get(currentIndex);
    }

    @Override
    public boolean hasPrev() {
        return (currentIndex - 1 > 0);
    }
    
}
