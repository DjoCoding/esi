public class RegularMovie extends Movie {
    private String ageRating;

    public RegularMovie(int id, String title, int duration, String ageRating) {
        super(id, title, duration);
        this.ageRating = ageRating;
    }

    public String getAgeRating() {
        return ageRating;
    }
}
