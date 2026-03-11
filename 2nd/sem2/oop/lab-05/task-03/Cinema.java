import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String name;
    private final List<Movie> movies = new ArrayList<>();
    private final List<Screen> screens = new ArrayList<>();
    private int totalScreensCapacity = 0;

    public Cinema(String name) {
        this.name = name;
    }

    public boolean addMovie(Movie m) {
        if (this.totalScreensCapacity <= this.movies.size())
            return false;

        int index = this.findMovieById(m.getId());
        if (index != -1)
            return false;

        this.movies.add(m);
        return true;
    }

    public boolean removeMovieById(int id) {
        int i = 0;
        while (i < this.movies.size()) {
            if (this.movies.get(i).getId() == id)
                break;
            i += 1;
        }

        if (i == this.movies.size())
            return false;

        this.movies.remove(i);
        return true;
    }

    public int getTotalMoviesDuration() {
        int sum = 0;
        for (Movie m : this.movies) {
            sum += m.getDuration();
        }
        return sum;
    }

    public void printMovies() {
        System.out.println(this.movies.toString());
    }

    public boolean addScreen(Screen s) {
        int index = this.findScreenById(s.getId());
        if (index != -1)
            return false;
        this.screens.add(s);
        this.totalScreensCapacity += s.getCapacity();
        return true;
    }

    public void printScreens() {
        System.out.println(this.screens.toString());
    }

    private int findMovieById(int id) {
        int i = 0;
        while (i < this.movies.size()) {
            if (this.movies.get(i).getId() == id)
                return i;
            i += 1;
        }
        return -1;
    }

    private int findScreenById(int id) {
        int i = 0;
        while (i < this.screens.size()) {
            if (this.screens.get(i).getId() == id)
                return i;
            i += 1;
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
