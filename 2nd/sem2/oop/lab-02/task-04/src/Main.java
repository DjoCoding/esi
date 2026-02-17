import java.util.Iterator;
import java.util.Scanner;

class StringPartGenerator implements Iterator<String> {
    private String content;

    @Override
    public boolean hasNext() {
        return this.content.length() != 0;
    }

    @Override
    public String next() {
        int i = 0;
        while (i < this.content.length()) {
            if (Character.isSpaceChar(this.content.charAt(i)))
                break;
            i += 1;
        }

        String result = this.content.substring(0, i);
        this.content = this.content.substring(i, this.content.length()).trim();

        return result;
    }

    public StringPartGenerator content(String content) {
        this.content = content.trim();
        return this;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type string: ");
        String string = scanner.nextLine();

        StringPartGenerator sg = new StringPartGenerator().content(string);

        for (String s = sg.next(); sg.hasNext(); s = sg.next()) {
            System.out.println(s);
        }

        scanner.close();
    }
}