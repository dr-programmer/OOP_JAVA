public interface SmartDevice {

    void turnOn();

    interface SmartDeviceBuilder {
        SmartDevice build();
    }
}
