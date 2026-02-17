import java.util.Scanner;

class PasswordValidator {
    public enum Violation {
        INVALID_LENGTH("Length must be between 8 and 16 characters"),
        MUST_AT_LEAST_CONTAIN_ONE_UPPERCASE_LETTER("Must contain at least one uppercase letter (A–Z)"),
        MUST_AT_LEAST_CONTAIN_ONE_LOWECASE_LETTER("Must contain at least one lowercase letter (a–z)"),
        MUST_AT_LEAST_CONTAIN_ONE_DIGIT("Must contain at least one digit (0–9)"),
        MUST_AT_LEAST_CONTAIN_SPECIAL_CHAR("Must contain at least one special character (@ # $ % !)"),
        MUST_NOT_CONTAIN_SPACE("Must not contain spaces"),
        MUST_NOT_CONTAIN_THE_SAME_CHAR_3_TIMES_IN_A_ROW("Must not contain the same character 3 times in a row");

        private final String message;

        Violation(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }

    private static boolean hasUppercase(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    private static boolean hasLowercase(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isLowerCase(c))
                return true;
        }
        return false;
    }

    private static boolean hasDigit(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    private static boolean hasSpecial(String string) {
        String special = "@#$%!";
        for (char c : string.toCharArray()) {
            if (special.indexOf(c) != -1)
                return true;
        }
        return false;
    }

    private static boolean hasSpace(String string) {
        return string.contains(" ");
    }

    private static boolean hasRepetition(String string, int times) {
        if (string.length() == 0)
            return false;

        char prev = string.charAt(0);
        int counter = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == prev) {
                counter++;
                if (counter >= times)
                    return true;
            } else {
                prev = string.charAt(i);
                counter = 1;
            }
        }

        return false;
    }

    private static boolean hasValidLength(String string, int min, int max) {
        return string.length() >= min && string.length() <= max;
    }

    public static Violation validate(String password) {
        if (!hasValidLength(password, 8, 16))
            return Violation.INVALID_LENGTH;

        if (!hasUppercase(password))
            return Violation.MUST_AT_LEAST_CONTAIN_ONE_UPPERCASE_LETTER;

        if (!hasLowercase(password))
            return Violation.MUST_AT_LEAST_CONTAIN_ONE_LOWECASE_LETTER;

        if (!hasDigit(password))
            return Violation.MUST_AT_LEAST_CONTAIN_ONE_DIGIT;

        if (!hasSpecial(password))
            return Violation.MUST_AT_LEAST_CONTAIN_SPECIAL_CHAR;

        if (hasSpace(password))
            return Violation.MUST_NOT_CONTAIN_SPACE;

        if (hasRepetition(password, 3))
            return Violation.MUST_NOT_CONTAIN_THE_SAME_CHAR_3_TIMES_IN_A_ROW;

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a string: ");
        String string = scanner.nextLine();

        scanner.close();

        PasswordValidator.Violation violation = PasswordValidator.validate(string);
        if (violation == null) {
            System.out.println("ACCEPTED");
            return;
        }

        System.out.println("REJECTED: %s".formatted(violation.toString()));
    }
}
