import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type N: ");
        int n = scanner.nextInt();

        if (n < 1 || n > 10_000) {
            System.err.println("Integer N = %d must be between 1 and 10 000".formatted(n));
            System.exit(1);
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            System.out.print("Type number %d: ".formatted(i + 1));
            int value = scanner.nextInt();
            values.add(Integer.valueOf(value));
        }

        scanner.close();

        values = values.stream().sorted().toList();

        int sum = values.stream().reduce(0, (prev, curr) -> prev + curr);
        double avg = sum * 1.0 / n;
        int min = values.get(0);
        int max = values.get(values.size() - 1);
        int count = values.stream().reduce(0, (prev, curr) -> {
            if (curr % 2 == 0)
                return prev + 1;
            return prev;
        });

        System.out.println(("\n\n\n\rMin: %d\n\r" +
                "Max: %d\n\r" +
                "Sum: %d\n\r" +
                "Average: %.2f\n\r" +
                "Count of Even: %d\n").formatted(
                        min,
                        max,
                        sum,
                        avg,
                        count));
    }
}