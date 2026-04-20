package absclasses;

import classes.Person;

public abstract class Employee extends Person {
    private final int id;
    private int salary;

    public Employee(String name, int age, int id, int salary) {
        super(name, age);
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public abstract double calculateBonus();
}
