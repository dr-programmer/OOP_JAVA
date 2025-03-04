public class SmartLight implements SmartDevice {
    private Double intensity;
    private Integer color;

    public SmartLight(SmartLightBuilder builder) {
        this.intensity = builder.intensity;
        this.color = builder.color;
    }

    @Override
    public void turnOn() {
        System.out.println("SmartLight is ON");
    }

    public static class SmartLightBuilder implements SmartDeviceBuilder {
        private Double intensity;
        private Integer color;

        public SmartLightBuilder setIntensity(Double intensity) {
            this.intensity = intensity;
            return this;
        }

        public SmartLightBuilder setColor(Integer color) {
            this.color = color;
            return this;
        }

        @Override
        public SmartDevice build() {
            return new SmartLight(this);
        }
    }
}
