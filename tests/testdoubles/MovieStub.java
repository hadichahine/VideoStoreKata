package testdoubles;

import movie.Movie;
import movie.PricingData;

public class MovieStub extends Movie {

    private double rental;

    public MovieStub(double salePrice, double rentalPrice){
        super("dummy",new PricingData(salePrice));
        rental = rentalPrice;
    }

    public MovieStub(String movieTitle) {
        super(movieTitle);
    }

    @Override
    public double rentalCost(int daysRented) {
        return rental;
    }

}
