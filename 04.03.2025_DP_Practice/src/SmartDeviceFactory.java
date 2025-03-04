public class SmartDeviceFactory {
    public static SmartDevice getSmartDevice(String deviceName) {
        SmartDevice smartDevice = null;
        if(deviceName.equals("SmartLight")) {
            smartDevice = new SmartLight.SmartLightBuilder().build();
        }
        else if(deviceName.equals("SmartAC")) {
            smartDevice = new SmartAC.SmartACBuilder().build();
        }
        else if(deviceName.equals("SmartSpeaker")) {
            smartDevice = new SmartSpeaker.SmartSpeakerBuilder().build();
        }
        return smartDevice;
    }
}
