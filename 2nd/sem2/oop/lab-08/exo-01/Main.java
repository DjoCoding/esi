import classes.Book;
import classes.Library;
import classes.Magazine;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addItem(new Book("My Book", "Mohammed Djaoued BOUHADDA", 2024));
        lib.addItem(new Magazine("My Magazine", "Mohammed Djaoued BOUHADDA", 2023));
        lib.sortItems();
        lib.displayAllItems();
    }
}