package classes;

import absclasses.LibraryItem;

public class Magazine extends LibraryItem {

    public Magazine(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine(title=%s, author=%s, year=%d)".formatted(this.title, this.author, this.year));
    }
}
