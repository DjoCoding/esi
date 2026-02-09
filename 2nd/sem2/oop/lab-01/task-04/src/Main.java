import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        if(args.length != 1) {
            System.err.println("Invalid arguments, expected 1 single integer value 0000-9999");
            System.exit(1);
        }

        int value = Parser.parseIntOrFail("value", args[0]);

        if(value < 0 || value > 9999) {
            System.err.println("Invalid value, expected value should be in range 0000-9999");
            System.exit(1);
        }

        Map<Integer, Integer> result = Counter.count(value);
        Integer[] keys = result.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, Collections.reverseOrder());

        for(Integer key: keys) {
            System.out.printf("%3dc: %d%n", key, result.get(key));
        }

        System.exit(0);
    }
}