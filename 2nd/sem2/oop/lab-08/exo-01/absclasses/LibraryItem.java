package absclasses;

public abstract class LibraryItem implements Comparable<LibraryItem> {
    protected String title;
    protected String author;
    protected int year;

    public LibraryItem(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract void displayInfo();

    @Override
    public int compareTo(LibraryItem o) {
        if (o == null)
            return 1;

        LibraryItem item = (LibraryItem) o;
        return this.year - item.year;

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }
}
