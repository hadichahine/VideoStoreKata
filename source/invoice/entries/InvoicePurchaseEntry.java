package invoice.entries;

import movie.Movie;
import purchase.Purchase;

public class InvoicePurchaseEntry {

    private Movie movie;
    private double cost;

    public InvoicePurchaseEntry(Purchase purchase) {
        movie = purchase.getMovie();
        cost = purchase.value();
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object candidate) {
        InvoicePurchaseEntry candidateInvoicePurchaseEntry = (InvoicePurchaseEntry) candidate;
        if(isEncapsulatedMovieEquals(candidateInvoicePurchaseEntry.getMovie()) &&
                isEncapsulatedCostEquals(candidateInvoicePurchaseEntry.getCost()))
            return true;
        else return false;
    }

    private boolean isEncapsulatedMovieEquals(Movie givenMovie) {
        return movie.equals(givenMovie);
    }

    private boolean isEncapsulatedCostEquals(double givenCost){
        return cost == givenCost;
    }

}
