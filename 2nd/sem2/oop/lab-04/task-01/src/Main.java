class SmartThermostat {
    private String location = null;
    private double currentTemp = 0;
    private double targetTemp = 0;
    private boolean ecoMode = false;
    private boolean isOn = false;

    public SmartThermostat() {
    }

    public SmartThermostat(String location, double currentTemp, double targetTemp, boolean ecoMode, boolean isOn) {
        this.targetTemp = targetTemp;
        this.currentTemp = currentTemp;
        this.isOn = isOn;
        this.ecoMode = ecoMode;
        this.location = location;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public void setTargetTemp(double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public void togglEcoMode() {
        this.ecoMode = !this.ecoMode;
    }

    public void step(double outsideTemp) {
        this.currentTemp = outsideTemp;
    }

    public String status() {
        return "current: %s\n\rtarget: %s\n\reco: %b\n\rlocation: %s\n".formatted(
                this.currentTemp,
                this.targetTemp,
                this.ecoMode,
                this.location);
    }
}

public class Main {
    public static void main(String[] args) {
        SmartThermostat s = new SmartThermostat(
                "House",
                30,
                20,
                false,
                false);

        s.turnOn();

        for (int i = 30; i > 20; --i) {
            s.step(i);
            System.out.println(
                    s.status());
        }

        s.turnOff();
    }
}