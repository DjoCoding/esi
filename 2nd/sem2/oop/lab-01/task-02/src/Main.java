class Parser {
    public static int parseIntegerOrFail(String s) {
        try { return Integer.parseInt(s); }
        catch(NumberFormatException err) {
            System.err.println("Value `%s` should be of type integer".formatted(s));
            System.exit(1);
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int value = Parser.parseIntegerOrFail(args[0]);

        if(value < 1000 || value > 9999) {
            System.err.println("value %d must be of 4 digits".formatted(value));
            System.exit(1);
        }

        if(value % 2 != 0) {
            System.out.println("Invalid value since %d is not even".formatted(value));
            System.exit(0);            
        }
        
        int a = value / 1000;
        int b = (value / 100) % 10;
        int c = (value / 10) % 10;
        int d = value % 10;

        if(a + d != b + c) {
            System.out.println("Invalid value since %d + %d != %d + %d".formatted(a, d, b, c));
            System.exit(0);
        }

        System.out.println("Value %d is valid".formatted(value));
    }
}