package customer;

import invoice.InvoicePrinterController;
import invoice.InvoicePrinter;
import invoice.RentalPurchaseAddable;
import purchase.Purchase;
import rental.Rental;

public class Statement implements RentalPurchaseAddable{

    private ValuableTotalCalculator valuableTotalCalculator;
    private InvoicePrinter printer;
    private InvoicePrinterController invoicePrinterController;

    public Statement(InvoicePrinter invoicePrinter){
        setInvoicePrinter(invoicePrinter);
        initBehaviorDelegates();
    }

    private void setInvoicePrinter(InvoicePrinter invoicePrinter){
        printer = invoicePrinter;
    }

    private void initBehaviorDelegates() {
        valuableTotalCalculator = new ValuableTotalCalculator();
        invoicePrinterController = new InvoicePrinterController(printer);
    }

    @Override
    public void addMovieRental(Rental rental) {
        invoicePrinterController.addMovieRental(rental);
        valuableTotalCalculator.addNewValuable(rental);
    }

    @Override
    public void addMoviePurchase(Purchase purchase) {
        invoicePrinterController.addMoviePurchase(purchase);
        valuableTotalCalculator.addNewValuable(purchase);
    }

    public double toBePaidValue() {
        return valuableTotalCalculator.netTotal();
    }

    public void printInvoice() {
        invoicePrinterController.done();
    }

}
