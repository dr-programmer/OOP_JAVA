public class Main {
    public static void main(String[] args) {
        SmartHomeManager oracle = SmartHomeManager.getInstance();

        SmartDevice light = SmartDeviceFactory.getSmartDevice("SmartLight");
        SmartDevice ac = new SmartAC.SmartACBuilder().setMode(1).setTemperature(19.0).build();
        SmartDevice speaker = new SmartSpeaker.SmartSpeakerBuilder().setIntensity(3.0).build();

        SmartDevice heater = new HeaterAdapter(new OldHeater());
        heater.turnOn();
    }
}