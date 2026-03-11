import java.util.Optional;

public class TextFile extends BaseFile {
    private String extension;
    private static final String[] allowedExtensions = {
            ".txt"
    };

    public TextFile(String name, String path, byte[] content) {
        Optional<String> ext = Utils.matchExtension(name, TextFile.allowedExtensions);
        if (ext.isEmpty()) {
            throw new RuntimeException("Invalid file extension for text file.");
        }

        super(name, path, content);
        this.extension = ".txt";
    }

    public String getExtension() {
        return extension;
    }

    public void rename(String name) {
        Optional<String> ext = Utils.matchExtension(name, TextFile.allowedExtensions);
        if (ext.isEmpty()) {
            throw new RuntimeException("Invalid file extension for text file.");
        }
        this.setName(name);
    }
}
