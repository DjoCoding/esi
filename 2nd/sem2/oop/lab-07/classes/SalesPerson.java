package classes;

import absclasses.Employee;
import interfaces.Manager;

public class SalesPerson extends Employee implements Manager {
    private double salesAmount;

    public SalesPerson(String name, int age, int id, int salary, double salesAmount) {
        super(name, age, id, salary);
        this.salesAmount = salesAmount;
    }

    public void approveLeave(String employeeName) {
        System.out.println("Leave approve for employee %s".formatted(employeeName));
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculateBonus() {
        return this.salesAmount * 0.1;
    }

}
