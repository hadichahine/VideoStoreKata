package rental;

import customer.Valuable;
import movie.Movie;

public class Rental implements Valuable{

    private Movie movie;
    private int daysRented;

    public Rental(Movie rentedMovie, int daysMovieRented) {
        movie = rentedMovie;
        daysRented = daysMovieRented;
    }

    public Movie getMovie(){
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public double value(){
        return movie.rentalCost(daysRented);
    }

}
