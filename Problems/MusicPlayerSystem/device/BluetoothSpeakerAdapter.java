package Problems.MusicPlayerSystem.device;

import Problems.MusicPlayerSystem.external.BluetoothSpeakerAPI;
import Problems.MusicPlayerSystem.models.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice {
    private BluetoothSpeakerAPI bluetoothApi;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI api) {
        this.bluetoothApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        bluetoothApi.playSoundViaBluetooth(payload);
    }
}
