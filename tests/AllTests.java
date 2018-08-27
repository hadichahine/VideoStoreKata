import discounting.DiscountTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import purchasing.MovieBuyingForMoviesTest;
import renting.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MovieBuyingForMoviesTest.class,
        InvoicePrintingForRentalsTest.class,
        MovieRentalForChildrenMoviesTest.class,
        MovieRentalForNewReleasesTest.class,
        MovieRentalForRegularMoviesTest.class,
        StatementCalculationForRentalsTest.class,
        DiscountTest.class
})


public class AllTests {}
