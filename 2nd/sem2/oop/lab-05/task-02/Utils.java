import java.util.Optional;

public class Utils {
    public static Optional<String> matchExtension(String name, String[] allowedExtensions) {
        for (String ext : allowedExtensions) {
            if (name.endsWith(ext)) {
                return Optional.of(ext);
            }
        }
        return Optional.empty();
    }
}
