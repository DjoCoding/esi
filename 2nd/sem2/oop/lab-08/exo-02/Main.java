import classes.Book;
import classes.StorageBox;

public class Main {
    public static void main(String[] args) {
        StorageBox<String> stringBox = new StorageBox<>("Hello World");
        StorageBox<Integer> integerBox = new StorageBox<>(Integer.valueOf(1));
        StorageBox<Book> bookBox = new StorageBox<>(new Book("Hello World", "Mohammed Djaoued BOUHADDA", 2024));
        stringBox.displayItem();
        integerBox.displayItem();
        bookBox.displayItem();
    }
}