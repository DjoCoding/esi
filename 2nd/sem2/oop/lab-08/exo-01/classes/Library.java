package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import absclasses.LibraryItem;
import exceptions.DuplicateItemException;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();

    public Library() {

    }

    public void addItem(LibraryItem item) throws DuplicateItemException {
        if (item == null)
            throw new IllegalArgumentException();

        Iterator<LibraryItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            LibraryItem current = iterator.next();
            if (current.getTitle().equals(item.getTitle())) {
                throw new DuplicateItemException("Title %s already exists".formatted(item.getTitle()));
            }
        }

        this.items.add(item);
    }

    public void displayAllItems() {
        Iterator<LibraryItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            LibraryItem current = iterator.next();
            current.displayInfo();
        }
    }

    public void sortItems() {
        Collections.sort(this.items);
    }
}
