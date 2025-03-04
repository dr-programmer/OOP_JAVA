public class SmartAC implements SmartDevice {
    private Double temperature;
    private Integer mode;

    public SmartAC(SmartACBuilder builder) {
        this.temperature = builder.temperature;
        this.mode = builder.mode;
    }

    @Override
    public void turnOn() {
        System.out.println("SmartAC is ON");
    }

    public static class SmartACBuilder implements SmartDeviceBuilder {
        private Double temperature;
        private Integer mode;

        SmartACBuilder setTemperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        SmartACBuilder setMode(Integer mode) {
            this.mode = mode;
            return this;
        }

        @Override
        public SmartDevice build() {
            return new SmartAC(this);
        }
    }
}
