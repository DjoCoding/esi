package classes;

import absclasses.LibraryItem;

public class Book extends LibraryItem {

    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Book(title=%s, author=%s, year=%d)".formatted(this.title, this.author, this.year));
    }
}
