import java.util.Random;

class Globals {
    public static final String plateNumber = "4584 125 31";
    public static final int maxSpeed = 220;
    public static final double pricePerKM = 20.0;
    public static final int STEPS = 10;
}

public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi(
                Globals.plateNumber,
                Globals.maxSpeed,
                Globals.pricePerKM);

        Random randomGenerator = new Random();
        for (int i = 0; i < Globals.STEPS; ++i) {
            int delta = randomGenerator.nextInt(0, 10);

            // action == 0 => Brake
            // action == 1 => Accelerate
            int action = randomGenerator.nextInt(0, 2);
            if (action == 0) {
                taxi.brake(delta);
            } else {
                taxi.accelerate(delta);
            }

            boolean meterValue = randomGenerator.nextBoolean();

            if (meterValue)
                taxi.startMeter();
            else
                taxi.stopMeter();

            System.out.println(taxi.info());
        }
    }
}
