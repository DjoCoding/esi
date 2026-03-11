import java.util.Date;

public class BaseFile {
    private String name;
    private String path;
    private int size;
    private byte[] content;
    private final Date createdAt;
    private Date updatedAt;
    private Date accessedAt;

    public BaseFile(String name, String path, byte[] content) {
        if (!path.endsWith(name))
            throw new RuntimeException("Invalid path to file.");

        this.name = name;
        this.content = content;
        this.size = this.content.length;
        this.path = path;
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
        this.accessedAt = this.createdAt;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public Date getCreationDate() {
        return createdAt;
    }

    public Date getAccessDate() {
        return accessedAt;
    }

    public Date getUpdateDate() {
        return updatedAt;
    }

    public String getPath() {
        return path;
    }

    protected void setName(String name) {
        StringBuilder sb = new StringBuilder();

        sb
                .append(this.path.substring(0, this.path.length() - this.name.length()))
                .append(name);

        this.path = sb.toString();
        this.name = name;
    }
}
