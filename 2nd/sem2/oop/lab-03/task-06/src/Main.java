class Solution {
    public static int sumDigits(int n) {
        if (n < 0)
            throw new UnsupportedOperationException();
        if (n == 0)
            return 0;
        return n % 10 + Solution.sumDigits((n / 10));
    }

    private static int reverseNumber(int n, int reversed) {
        if (n == 0)
            return reversed;
        return Solution.reverseNumber(n / 10, reversed * 10 + n % 10);
    }

    public static int reverseNumber(int n) {
        if (n < 0)
            throw new UnsupportedOperationException();
        return Solution.reverseNumber(n, 0);
    }
}

public class Main {
    public static void main(String[] args) {
    }
}