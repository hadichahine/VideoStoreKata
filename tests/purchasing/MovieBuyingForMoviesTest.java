package purchasing;

import customer.Statement;
import invoice.entries.InvoicePurchaseEntry;
import movie.PricingData;
import org.junit.Before;
import purchase.Purchase;
import movie.Movie;
import org.junit.BeforeClass;
import org.junit.Test;
import testdoubles.InvoicePrinterSpy;
import testdoubles.MovieStub;

import static org.junit.Assert.*;

public class MovieBuyingForMoviesTest {

    private static Purchase firstMoviePurchase,secondMoviePurchase,thirdMoviePurchase;
    private static InvoicePurchaseEntry expectedInvoicePurchaseEntryForFirstMovie,
                                        expectedInvoicePurchaseEntryForSecondMovie,
                                        expectedInvoicePurchaseEntryForThirdMovie;
    private Statement statement;
    private InvoicePrinterSpy invoicePrinterSpy;

    @BeforeClass
    public static void initializeConstantsForTest(){
        Movie firstMovie = new MovieStub("DummyName");
        firstMoviePurchase = new Purchase(firstMovie);
        Movie secondMovie = new MovieStub("DummyName2");
        secondMoviePurchase = new Purchase(secondMovie);
        Movie thirdMovie = new MovieStub("DummyName3");
        thirdMoviePurchase = new Purchase(thirdMovie);
        expectedInvoicePurchaseEntryForFirstMovie = new InvoicePurchaseEntry(firstMoviePurchase);
        expectedInvoicePurchaseEntryForSecondMovie = new InvoicePurchaseEntry(secondMoviePurchase);
        expectedInvoicePurchaseEntryForThirdMovie = new InvoicePurchaseEntry(thirdMoviePurchase);
    }

    @Before
    public void setup(){
        invoicePrinterSpy = new InvoicePrinterSpy();
        statement = new Statement(invoicePrinterSpy);
    }

    @Test
    public void testMovieSaleFor1Movie(){
        Movie movie = createMovieWithSalePrice(10);
        statement.addMoviePurchase(new Purchase(movie));
        assertEquals(10, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testMovieSaleFor2Movies(){
        Movie firstMovie = createMovieWithSalePrice(10);
        Movie secondMovie = createMovieWithSalePrice(7);
        statement.addMoviePurchase(new Purchase(firstMovie));
        statement.addMoviePurchase(new Purchase(secondMovie));
        assertEquals(10+7, statement.toBePaidValue(),0.009);
    }

    @Test
    public void testInvoiceGenerationFor1MovieSale(){
        statement.addMoviePurchase(firstMoviePurchase);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenSalesEntries(expectedInvoicePurchaseEntryForFirstMovie));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }

    @Test
    public void testInvoiceGenerationFor2MovieSales(){
        statement.addMoviePurchase(firstMoviePurchase);
        statement.addMoviePurchase(secondMoviePurchase);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenSalesEntries(expectedInvoicePurchaseEntryForFirstMovie,
                                                                expectedInvoicePurchaseEntryForSecondMovie));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }

    @Test
    public void testInvoiceGenerationFor3MovieSales(){
        statement.addMoviePurchase(firstMoviePurchase);
        statement.addMoviePurchase(secondMoviePurchase);
        statement.addMoviePurchase(thirdMoviePurchase);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenSalesEntries(expectedInvoicePurchaseEntryForFirstMovie,
                                                        expectedInvoicePurchaseEntryForSecondMovie,
                                                        expectedInvoicePurchaseEntryForThirdMovie));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }

    private Movie createMovieWithSalePrice(double salePrice){
        return new MovieStub(salePrice,0);
    }
}
