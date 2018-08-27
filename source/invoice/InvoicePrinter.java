package invoice;

import invoice.entries.InvoicePurchaseEntry;
import invoice.entries.InvoiceRentalEntry;

public interface InvoicePrinter {

    void newInvoice();

    void addRentalToInvoice(InvoiceRentalEntry invoiceRentalEntry);

    void addSaleToInvoice(InvoicePurchaseEntry invoicePurchaseEntry);

    void printOut();

}
