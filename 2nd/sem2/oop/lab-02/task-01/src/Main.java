import java.util.Scanner;

class Compressor {
    public static String compress(String string) {
        if (string.length() == 0)
            return string;

        StringBuilder sb = new StringBuilder();

        char current = string.charAt(0);
        int counter = 1;
        for (int i = 1; i < string.length(); ++i) {
            if (string.charAt(i) == current) {
                counter += 1;
                continue;
            }

            sb.append("%c%d".formatted(current, counter));
            current = string.charAt(i);
            counter = 1;
        }

        sb.append("%c%d".formatted(current, counter));
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a string: ");
        String string = scanner.nextLine();

        String result = Compressor.compress(string);
        System.out.println("Compressed string: %s".formatted(result));

        scanner.close();
    }
}