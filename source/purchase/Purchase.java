package purchase;

import customer.Valuable;
import movie.Movie;

public class Purchase implements Valuable{

    private Movie movie;

    public Purchase(Movie purchasedMovie){
        movie = purchasedMovie;
    }

    @Override
    public double value(){
        return movie.saleCost();
    }

    public Movie getMovie() {
        return movie;
    }
}
