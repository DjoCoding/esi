package classes;

import absclasses.Employee;

public class Developer extends Employee {
    public int experience;

    public Developer(String name, int age, int id, int salary, int experience) {
        super(name, age, id, salary);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void approveLeave(String employeeName) {
        System.out.println("Leave approve for employee %s".formatted(employeeName));
    }

    @Override
    public double calculateBonus() {
        return this.getSalary() * (this.experience * 0.01);
    }
}
