import java.util.Scanner;

class Encryptor {
    private static char wrapChar(char c, int shift) {
        char base = Character.isUpperCase(c) ? 'A' : 'a';
        return (char) (base + (c - base + shift) % 26);
    }

    public static String cipher(String string, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            sb.append(Encryptor.wrapChar(c, shift));
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a string: ");
        String string = scanner.nextLine();

        System.out.print("Type the shift: ");
        int shift = scanner.nextInt();

        String result = Encryptor.cipher(string, shift);
        System.out.println("Cipher is: %s".formatted(result));

        scanner.close();
    }
}