package testdoubles;

import invoice.entries.InvoicePurchaseEntry;
import invoice.entries.InvoiceRentalEntry;
import invoice.InvoicePrinter;

import java.util.ArrayList;
import java.util.Arrays;

public class InvoicePrinterSpy implements InvoicePrinter {

    private boolean newInvoiceFlagSet;
    private boolean done;
    private ArrayList<InvoicePurchaseEntry> invoicePurchaseEntries = new ArrayList<InvoicePurchaseEntry>();
    private ArrayList<InvoiceRentalEntry> invoiceRentalEntries = new ArrayList<InvoiceRentalEntry>();

    public void newInvoice(){
        newInvoiceFlagSet = true;
        invoicePurchaseEntries = new ArrayList<InvoicePurchaseEntry>();
        invoiceRentalEntries = new ArrayList<InvoiceRentalEntry>();
    }

    public void addRentalToInvoice(InvoiceRentalEntry invoiceRentalEntry){
        invoiceRentalEntries.add(invoiceRentalEntry);
    }

    @Override
    public void addSaleToInvoice(InvoicePurchaseEntry invoicePurchaseEntry) {
        invoicePurchaseEntries.add(invoicePurchaseEntry);
    }

    public void printOut(){
        if(!newInvoiceFlagSet)
            throw new IllegalStateException();
        done = true;
    }

    public boolean isSameAsWrittenRentalEntries(InvoiceRentalEntry... entries){
        return Arrays.equals(invoiceRentalEntries.toArray(),entries);
    }

    public boolean isSameAsWrittenSalesEntries(InvoicePurchaseEntry... suggestedInvoicePurchaseEntries){
        return Arrays.equals(invoicePurchaseEntries.toArray(),suggestedInvoicePurchaseEntries);
    }

    public boolean didPrintOut() {
        return done;
    }
}