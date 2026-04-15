class Shape {
    public double calculateArea() {
        return 0;
    }

    public void displayInfo() {
        return;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public void displayInfo() {
        String s = "Circle(%f)".formatted(this.radius);
        System.out.println(s);
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public void displayInfo() {
        String s = "Rectangle(w=%f,h=%f)".formatted(this.width, this.height);
        System.out.println(s);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(2),
                new Rectangle(1, 1)
        };

        for (int i = 0; i < shapes.length; ++i) {
            Shape shape = shapes[i];
            shape.displayInfo();
        }
    }
}