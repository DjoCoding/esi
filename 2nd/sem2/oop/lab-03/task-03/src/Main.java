import java.util.List;

class Solution {
    public static int countOccurences(List<Integer> values, int target) {
        return values.stream().reduce(0, (prev, curr) -> {
            if (curr == target)
                return prev + 1;
            return prev;
        });
    }

}

public class Main {
    public static void main(String[] args) {
        System.exit(0);
    }
}