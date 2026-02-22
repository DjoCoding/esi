import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // in-place solution
    public static List<Integer> roundInPlace(List<Integer> values, int k) {
        int size = values.size();
        int round = k % size;

        for (int i = 0; i < round; ++i) {
            // save last one
            Integer last = values.get(size - 1);

            // make the shift
            for (int j = size - 1; j > 0; --j) {
                values.set(j, values.get(j - 1));
            }

            // set last one at the beginning
            values.set(0, last);
        }

        return values;
    }

    public static List<Integer> round(final List<Integer> values, int k) {
        int size = values.size();
        int round = k % size;

        List<Integer> result = new ArrayList<>(size);

        for (int i = size - round; i < size; ++i)
            result.add(values.get(i));

        for (int i = 0; i < size - round; ++i)
            result.add(values.get(i));

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type n: ");
        int n = scanner.nextInt();

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            System.out.print("Type value %d: ".formatted(i + 1));
            int value = scanner.nextInt();
            values.add(value);
        }

        System.out.print("Type k: ");
        int k = scanner.nextInt();

        scanner.close();

        List<Integer> roundedValues = Solution.roundInPlace(values, k);
        System.out.println(roundedValues);
    }
}