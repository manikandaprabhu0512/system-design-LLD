package Problems.MusicPlayerSystem.strategies;

import Problems.MusicPlayerSystem.models.Playlist;
import Problems.MusicPlayerSystem.models.Song;

public interface PlayStrategy {
    void setPlayList(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrev();
    default void addNextSong(Song song){};
}
