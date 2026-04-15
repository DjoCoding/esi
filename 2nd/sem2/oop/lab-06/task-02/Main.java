class Calculator {
    public Calculator() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    double multiply(double a, double b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(2, 3);
        calculator.add(2, 3, 4);
    }
}