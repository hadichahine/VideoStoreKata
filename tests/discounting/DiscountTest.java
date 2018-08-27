package discounting;

import customer.Statement;
import movie.DiscountDecorator;
import movie.Movie;
import org.junit.Before;
import org.junit.Test;
import purchase.Purchase;
import rental.Rental;
import testdoubles.InvoicePrinterSpy;
import testdoubles.MovieStub;

import static org.junit.Assert.*;

public class DiscountTest {

    private Statement statement;

    @Before
    public void setup(){
        statement = new Statement(new InvoicePrinterSpy());
    }

    @Test
    public void testDiscountForRental() {
        Movie movie = createMovieWithRentalPriceAndRentalPercentage(4,50);
        statement.addMovieRental(new Rental(movie,493));
        assertEquals(2, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testDiscountForPurchase(){
        Movie movie = createMovieWithSalePriceAndSaleDiscount(8,50);
        statement.addMoviePurchase(new Purchase(movie));
        assertEquals(4, statement.toBePaidValue(),0.009);
    }

    //TODO Behavior for wrong discount

    private Movie createMovieWithRentalPriceAndRentalPercentage(double rentalPrice,double rentalDiscountPercentage){
        return new DiscountDecorator(new MovieStub(0, rentalPrice),rentalDiscountPercentage,0);
    }

    private Movie createMovieWithSalePriceAndSaleDiscount(double salePrice,double purchaseDiscountPrecentage){
        return new DiscountDecorator(new MovieStub(salePrice, 0),0,purchaseDiscountPrecentage);
    }

}
