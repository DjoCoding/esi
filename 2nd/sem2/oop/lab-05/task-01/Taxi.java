public class Taxi extends Vehicle {
    public boolean meterOn;
    public final double pricePerKM;

    public Taxi(String plateNumber, int maxSpeed, double pricePerKM) {
        super(plateNumber, maxSpeed);
        this.pricePerKM = pricePerKM;
        this.meterOn = false;
    }

    public void startMeter() {
        this.meterOn = true;
    }

    public void stopMeter() {
        this.meterOn = false;
    }

    public String info() {
        return "Taxi{%s, meter: %s, pricePerKM: %.2f}".formatted(super.info(), String.valueOf(this.meterOn),
                this.pricePerKM);
    }
}