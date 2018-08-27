package invoice;

import invoice.entries.InvoicePurchaseEntry;
import invoice.entries.InvoiceRentalEntry;
import purchase.Purchase;
import rental.Rental;

public class InvoicePrinterController implements RentalPurchaseAddable{

    private InvoicePrinter invoicePrinter;

    public InvoicePrinterController(InvoicePrinter invoicePrinter){
        this.invoicePrinter = invoicePrinter;
        invoicePrinter.newInvoice();
    }

    @Override
    public void addMovieRental(Rental rental) {
        InvoiceRentalEntry invoiceRentalEntry = new InvoiceRentalEntry(rental);
        invoicePrinter.addRentalToInvoice(invoiceRentalEntry);
    }

    @Override
    public void addMoviePurchase(Purchase purchase) {
        InvoicePurchaseEntry invoicePurchaseEntry = new InvoicePurchaseEntry(purchase);
        invoicePrinter.addSaleToInvoice(invoicePurchaseEntry);
    }

    public void done(){
        invoicePrinter.printOut();
    }


}
