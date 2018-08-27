package renting;

import customer.Statement;
import movie.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rental.Rental;
import testdoubles.InvoicePrinterSpy;
import utils.TestRentalHelper;

public class StatementCalculationForRentalsTest {

    Statement statement;

    @Before
    public void setup(){
        statement = new Statement(new InvoicePrinterSpy());
    }

    @Test
    public void testCalculatePayForCustomerWithNoRentals() {
        Assert.assertEquals(0, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testCalculatePayForCustomerWithOne2Point44DollarsRental() {
        Movie movie = TestRentalHelper.createMovieWithRentalPrice(2.44);
        statement.addMovieRental(new Rental(movie,4343));
        Assert.assertEquals(2.44, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testCalculatePayForCustomerWithOne5DollarRental() {
        Movie movie = TestRentalHelper.createMovieWithRentalPrice(5);
        statement.addMovieRental(new Rental(movie,12331));
        Assert.assertEquals(5, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testSumOfRentalsForTwo5DollarRentals() {
        Movie movie = TestRentalHelper.createMovieWithRentalPrice(5);
        statement.addMovieRental(new Rental(movie, 41343));
        statement.addMovieRental(new Rental(movie, 1434));
        Assert.assertEquals(10, statement.toBePaidValue(), 0.009);
    }

}
