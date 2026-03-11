public class Main {
    public static void main(String[] args) {
        ImageFile image = new ImageFile("image.jpeg", "/images/image.jpeg", new byte[0]);
        TextFile text = new TextFile("file.txt", "files/file.txt", new byte[0]);

        image.rename("image2.jpeg");
        text.rename("file.jpeg"); // <-- this should throw an error.
    }
}
