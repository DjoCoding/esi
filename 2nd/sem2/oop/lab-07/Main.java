import classes.Developer;
import classes.SalesPerson;
import classes.Tester;

public class Main {
    public static void main(String[] args) {
        SalesPerson salesPerson = new SalesPerson(
                "Mohammed Djaoued BOUHADDA", 20, 1, 20000, 2000);

        double bonus = salesPerson.calculateBonus();
        System.out.println("Bonus is: %s".formatted(bonus));

        salesPerson.approveLeave("Mohammed Djaoued BOUHADDA");

        Developer dev = new Developer("Mohammed Djaoued BOUHADDA", 20, 2, 2000000, 2);
        Tester tester = new Tester("Mohammed Djaoued BOUHADDA", 20, "Project X");
    }
}
