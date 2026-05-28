package Problems.MusicPlayerSystem.factory;

import Problems.MusicPlayerSystem.device.BluetoothSpeakerAdapter;
import Problems.MusicPlayerSystem.device.HeadphonesAdapater;
import Problems.MusicPlayerSystem.device.IAudioOutputDevice;
import Problems.MusicPlayerSystem.device.WiredSpeakerAdapter;
import Problems.MusicPlayerSystem.enums.DeviceType;
import Problems.MusicPlayerSystem.external.BluetoothSpeakerAPI;
import Problems.MusicPlayerSystem.external.HeadphonesAPI;
import Problems.MusicPlayerSystem.external.WiredSpeakerAPI;

public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType type) {
        switch (type) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapater(new HeadphonesAPI());
        }
    }
}
