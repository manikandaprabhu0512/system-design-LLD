package Problems.MusicPlayerSystem.device;

import Problems.MusicPlayerSystem.external.HeadphonesAPI;
import Problems.MusicPlayerSystem.models.Song;

public class HeadphonesAdapater implements IAudioOutputDevice {
    private HeadphonesAPI headphonesApi;

    public HeadphonesAdapater(HeadphonesAPI api) {
        this.headphonesApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesApi.playSoundViaHeadphones(payload);
    }
}
