package renting;

import customer.Statement;
import invoice.entries.InvoiceRentalEntry;
import movie.Movie;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rental.Rental;
import testdoubles.InvoicePrinterSpy;
import utils.TestRentalHelper;

import static org.junit.Assert.*;

public class InvoicePrintingForRentalsTest {
    private static Rental firstMovieRentalStub,secondMovieRentalStub,thirdMovieRentalStub;
    private static InvoiceRentalEntry expectedRentalEntryForFirstRental,
            expectedRentalEntryForSecondRental,
            expectedRentalEntryForThirdRental;
    private Statement statement;
    InvoicePrinterSpy invoicePrinterSpy;

    @BeforeClass
    public static void initializeConstantsForTest(){
        Movie firstMovie = TestRentalHelper.createMovieWithRentalPrice(10);
        firstMovieRentalStub = new Rental(firstMovie,3);
        Movie secondMovie = TestRentalHelper.createMovieWithRentalPrice(30);
        secondMovieRentalStub = new Rental(secondMovie,8);
        Movie thirdMovie = TestRentalHelper.createMovieWithRentalPrice(50);
        thirdMovieRentalStub = new Rental(thirdMovie,9);
        expectedRentalEntryForFirstRental = new InvoiceRentalEntry(firstMovieRentalStub);
        expectedRentalEntryForSecondRental = new InvoiceRentalEntry(secondMovieRentalStub);
        expectedRentalEntryForThirdRental = new InvoiceRentalEntry(thirdMovieRentalStub);
    }

    @Before
    public void setup(){
        invoicePrinterSpy = new InvoicePrinterSpy();
        statement = new Statement(invoicePrinterSpy);
    }

    @Test
    public void testInvoiceGenerationFor1Rental(){
        statement.addMovieRental(firstMovieRentalStub);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenRentalEntries(expectedRentalEntryForFirstRental));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }

    @Test
    public void testInvoicePrintingFor2Rentals(){
        statement.addMovieRental(firstMovieRentalStub);
        statement.addMovieRental(secondMovieRentalStub);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenRentalEntries(expectedRentalEntryForFirstRental,
                expectedRentalEntryForSecondRental));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }

    @Test
    public void testInvoicePrintingFor3Rentals(){
        statement.addMovieRental(firstMovieRentalStub);
        statement.addMovieRental(secondMovieRentalStub);
        statement.addMovieRental(thirdMovieRentalStub);
        statement.printInvoice();
        assertTrue(invoicePrinterSpy.isSameAsWrittenRentalEntries(expectedRentalEntryForFirstRental,
                expectedRentalEntryForSecondRental,
                expectedRentalEntryForThirdRental));
        assertTrue(invoicePrinterSpy.didPrintOut());
    }
}
