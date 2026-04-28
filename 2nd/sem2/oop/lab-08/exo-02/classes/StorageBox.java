package classes;

public class StorageBox<T> {
    private T item;

    public StorageBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void displayItem() {
        System.out.println(this.item);
    }
}