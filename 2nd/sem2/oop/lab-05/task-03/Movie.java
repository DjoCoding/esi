public class Movie {
    private final int id;
    private final String title;
    private final int duration;

    public Movie(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
