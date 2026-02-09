class Calculator {
    record CalculationResult(double avg, Status status, boolean merit) {};

    enum Status {
        PASS,
        FAIL,
    };

    public static CalculationResult calculate(double quiz, double midterm, double _final) {
        double avg = quiz * 0.2 + midterm * 0.3 + _final * 0.5; 
        
        Status status = Status.PASS;
        if(avg < 50) { status = Status.FAIL; }

        boolean merit = false;
        if(avg >= 80) { merit = true; }

        return new CalculationResult(avg, status, merit);
    }
}

class Parser {
    public static double parseDoubleOrThrowAndExit(String key, String s) {
        try {
            return Double.parseDouble(s);
        } catch(NumberFormatException err) {
            System.err.println("Expected %s to be a doube but get `%s`".formatted(key, s));
            System.exit(1);
            return 0;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.err.println("Command only accepts 3 args: quiz, midterm, final");
            System.exit(1);
        }

        double quiz = Parser.parseDoubleOrThrowAndExit("quiz", args[0]);
        double midterm = Parser.parseDoubleOrThrowAndExit("midterm", args[1]);
        double _final = Parser.parseDoubleOrThrowAndExit("final", args[2]);

        Calculator.CalculationResult result = Calculator.calculate(quiz, midterm, _final);
        System.out.println("Average: %.2f\nStatus: %s\nMerit: %s\n".formatted(result.avg(), result.status(), result.merit()));
        System.exit(0);
    }
}