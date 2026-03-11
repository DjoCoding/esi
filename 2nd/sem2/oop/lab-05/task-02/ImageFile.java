import java.util.Optional;

public class ImageFile extends BaseFile {
    private String extension;
    private static final String[] allowedExtensions = {
            ".jpeg",
            ".png",
            ".jpg"
    };

    public ImageFile(String name, String path, byte[] content) {
        Optional<String> ext = Utils.matchExtension(name, ImageFile.allowedExtensions);
        if (ext.isEmpty()) {
            throw new RuntimeException("Invalid file extension for image file.");
        }

        super(name, path, content);
        this.extension = ext.get();
    }

    public String getExtension() {
        return extension;
    }

    public void rename(String name) {
        Optional<String> ext = Utils.matchExtension(name, ImageFile.allowedExtensions);
        if (ext.isEmpty()) {
            throw new RuntimeException("Invalid file extension for image file.");
        }
        this.setName(name);
    }
}
