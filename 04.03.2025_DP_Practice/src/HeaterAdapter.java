public class HeaterAdapter implements SmartDevice {
    private OldHeater oldHeater;

    public HeaterAdapter(OldHeater heater) {
        oldHeater = heater;
    }


    @Override
    public void turnOn() {
        oldHeater.heatUp(10);
    }

    public void turnOn(int level) {
        oldHeater.heatUp(level);
    }
}
