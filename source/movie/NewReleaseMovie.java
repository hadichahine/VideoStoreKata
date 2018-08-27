package movie;

public class NewReleaseMovie extends Movie{

    public NewReleaseMovie(String dummy_movie_name) {
        super(dummy_movie_name);
    }

    @Override
    public double rentalCost(int daysRented) {
        return 3*daysRented;
    }
}
