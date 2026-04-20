package classes;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person(");
        sb.append("name=");
        sb.append(this.name);
        sb.append(", ");
        sb.append("age=");
        sb.append(this.age);
        sb.append(")");
        return sb.toString();
    }
}