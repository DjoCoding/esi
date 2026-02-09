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

class Converter {
    private static double convertFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }

    private static double convertCelsius(double f) {
          return (f - 32) * 5 / 9;
    }

    private static double convertKm(double miles) {
        return miles * 0.621371;
    }

    private static double convertMiles(double kms) {
        return kms / 0.621371;
    }

    public static double convert(int option, double value) {
        switch (option) {
            case 1:
                return Converter.convertFahrenheit(value);
            case 2:
                return Converter.convertCelsius(value);
            case 3:
                return Converter.convertKm(value);
            case 4:
                return Converter.convertMiles(value);
            default:
                throw new UnsupportedOperationException();
        }
    }
}


public class Main {
    public static String getHelpContent() {
        return 
        "\r\nCommand: prog <option> <value>\r\nOptions:\r\n" +
        "1. Celsius -> Fahrenheit\r\n" + //
        "2. Fahrenheit -> Celsius\r\n" + //
        "3. Kilometers -> Miles\r\n" + //
        "4. Miles -> Kilometers" +
        "\r\n";
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println(Main.getHelpContent());
            System.exit(1);
        }

        int option = Parser.parseIntOrFail("option", args[0]);
        double value = Parser.parseDoubleOrFail("value", args[1]);

        if(option < 1 || option > 4) {
            System.err.println(Main.getHelpContent());
            System.err.println("Invalid option code");
            System.exit(1);
        }

        double result = Converter.convert(option, value);
        System.out.println("Result: %.2f".formatted(result));
        System.exit(0);
    }
}