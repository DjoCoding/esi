import java.util.Scanner;

class PalindromeStringFinder {
    private static boolean isPalindromeString(String string) {
        return string.equals(
                new StringBuilder(string).reverse().toString());
    }

    public static String find(String string) {
        String result = string.substring(0, 1);

        for (int i = 0; i < string.length() - 1; ++i) {
            for (int j = i + 1; j < string.length(); ++j) {
                String substring = string.substring(i, j + 1);
                if (!PalindromeStringFinder.isPalindromeString(substring))
                    continue;

                if (substring.length() > result.length()) {
                    result = substring;
                }
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a string: ");
        String string = scanner.nextLine();

        scanner.close();

        String result = PalindromeStringFinder.find(string);
        System.out.println("The longest palindrome string of `%s` is: %s".formatted(
                string,
                result));

    }
}