package utils;

import movie.Movie;
import rental.Rental;
import testdoubles.MovieStub;

public class TestRentalHelper {

    public static Movie createMovieWithRentalPrice(double rentalPrice) {
        return new MovieStub(0,rentalPrice);
    }

    public static Rental createRentalForMovie(Movie movie, final int daysRented) {
       return new Rental(movie,daysRented);
    }

}
