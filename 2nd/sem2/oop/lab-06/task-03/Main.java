class Employee {
    public final String name;
    public final double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return this.baseSalary;
    }

    public void displayInfo() {
        System.out.println("Employee(%s, %f)".formatted(this.name, this.baseSalary));
    }
}

class Manager extends Employee {
    public double bonus = 0;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary + this.bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println("Manager(%s, base=%f, bonus=%f)".formatted(this.name, this.baseSalary, this.bonus));
    }
}

class Developer extends Employee {
    public int overtimeHours = 0;
    public double hourRate = 0;

    public Developer(String name, double baseSalary, int overtimeHours, double hourRate) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        this.hourRate = hourRate;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary + this.overtimeHours * this.hourRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Manager(%s, base=%f, overtime_hours=%d, hour_rate=%f)".formatted(this.name, this.baseSalary,
                this.overtimeHours, this.hourRate));
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Mohammed Djaoued BOUHADDA", 20000, 330),
                new Developer("Mohammed Djaoued BOUHADDA", 20000, 2, 200)
        };

        for (int i = 0; i < employees.length; ++i) {
            Employee em = employees[i];
            em.displayInfo();
        }
    }
}