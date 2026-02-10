import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        do {
            System.out.print("Type number: ");
            n = scanner.nextInt();
            if(n >= 10 && n <= 50) { break; }
        } while(true);

        scanner.close();

        double value = Math.pow(n, 2);
        System.out.println("(%d)^2 = %.2f".formatted(n, value));
        
        System.exit(0);
    }
}