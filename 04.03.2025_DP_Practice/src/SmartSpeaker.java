public class SmartSpeaker implements SmartDevice {
    private Double intensity;
    private String language;

    public SmartSpeaker(SmartSpeakerBuilder builder) {
        this.intensity = builder.intensity;
        this.language = builder.language;
    }

    @Override
    public void turnOn() {
        System.out.println("SmartSpeaker is turned on");
    }

    public static class SmartSpeakerBuilder implements SmartDeviceBuilder {
        private Double intensity;
        private String language;

        SmartSpeakerBuilder setIntensity(Double intensity) {
            this.intensity = intensity;
            return this;
        }

        SmartSpeakerBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        @Override
        public SmartDevice build() {
            return new SmartSpeaker(this);
        }
    }
}
