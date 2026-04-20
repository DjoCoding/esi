package classes;

import interfaces.Manager;

public class Tester implements Manager {
    public final String name;
    public int age;
    public String project;

    public Tester(String name, int age, String project) {
        this.name = name;
        this.age = age;
        this.project = project;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public void approveLeave(String employeeName) {
        System.out.println("This function should do something");
    }
}