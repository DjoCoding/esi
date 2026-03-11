public class ThreeDMovie extends Movie {
    private final boolean glassesRequired;

    public ThreeDMovie(int id, String title, int duration, boolean glassesRequired) {
        super(id, title, duration);
        this.glassesRequired = glassesRequired;
    }

    public boolean areGlassesRequired() {
        return this.glassesRequired;
    }
}
