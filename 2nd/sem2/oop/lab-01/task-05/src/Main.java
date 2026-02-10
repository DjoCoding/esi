import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Parser {
    public static double parseDoubleOrFail(String key, String s) {
        try {
            return Double.parseDouble(s);
        } catch(NumberFormatException err) {
            System.err.println("Expected %s to be a double but get `%s`".formatted(key, s));
            System.exit(1);
            return 0;
        }
    }

    public static int parseIntOrFail(String key, String s) {
        try {
            return Integer.parseInt(s);
        } catch(NumberFormatException err) {
            System.err.println("Expected %s to be an integer but get `%s`".formatted(key, s));
            System.exit(1);
            return 0;
        }
    }
}

class Counter {
    public static Map<Integer, Integer> count(int value) {
        Integer[] availableCoins = {1, 2, 5, 10, 20, 50, 100, 200};
        Integer[] counts = {0, 0, 0, 0, 0, 0, 0, 0};
        
        int pointer = availableCoins.length - 1;
        int rest = value;

        while(pointer >= 0 && rest > 0) {
            if(availableCoins[pointer] <= rest) {
                rest -= availableCoins[pointer];
                counts[pointer] += 1;
                continue;
            }

            pointer -= 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < availableCoins.length; ++i) {
            map.put(availableCoins[i], counts[i]);
        }
        return map;
    } 
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> data = new ArrayList<Integer>();

        while(true) {
            int v = scanner.nextInt();
            if(v == 0) break;
            data.add(v);
        }

        scanner.close();

        if(data.size() == 0) {
            System.out.println("No data");
            System.exit(0);
        }

        int sum = data.stream().mapToInt(Integer::intValue).sum();
        System.out.println(
            "Sum: %d\r\n".formatted(sum) +
            "Count: %d".formatted(data.size())
        );

        if(sum > 0) {
            System.out.println("Average: %d".formatted(sum / data.size()));
        }

        System.exit(0);
    }
}