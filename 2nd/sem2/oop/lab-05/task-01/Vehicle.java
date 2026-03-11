public class Vehicle {
    public final String plateNumber;
    public final int maxSpeed;
    public int currentSpeed;

    public Vehicle(String plateNumber, int maxSpeed) {
        this.plateNumber = plateNumber;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    public void accelerate(int delta) {
        this.currentSpeed += delta;
        this.currentSpeed = Math.min(this.currentSpeed, this.maxSpeed);
    }

    public void brake(int delta) {
        this.currentSpeed -= delta;
        this.currentSpeed = Math.max(this.currentSpeed, 0);
    }

    public String info() {
        return "Vehicle[%s]{ current: %d, max: %d }".formatted(this.plateNumber, this.currentSpeed, this.maxSpeed);
    }
}