import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a string: ");
        String string = scanner.nextLine();
        scanner.close();

        int balance = 0;
        for (char c : string.toCharArray()) {
            if (balance < 0)
                break;

            if (c == '(') {
                balance += 1;
                continue;
            }

            if (c == ')') {
                balance -= 1;
                continue;
            }
        }

        System.out.println(balance == 0 ? "BALANCED" : "NOT-BALANCED");
    }
}