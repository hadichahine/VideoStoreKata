package invoice.entries;

import movie.Movie;
import rental.Rental;

public class InvoiceRentalEntry {

    private Movie movie;
    private int daysRented;
    private double cost;

    public InvoiceRentalEntry(Rental rental) {
        movie = rental.getMovie();
        cost = rental.value();
        daysRented = rental.getDaysRented();
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object candidate) {
        InvoiceRentalEntry candidateInvoiceRentalEntry = (InvoiceRentalEntry)candidate;
        if(isEncapsulatedMovieEquals(candidateInvoiceRentalEntry.getMovie()) &&
                isEncapsulatedDaysRentedEquals(candidateInvoiceRentalEntry.getDaysRented()) &&
                    isEncapsulatedCostEquals(candidateInvoiceRentalEntry.getCost()))
            return true;
        else return false;
    }

    private boolean isEncapsulatedMovieEquals(Movie givenMovie) {
        return movie.equals(givenMovie);
    }

    private boolean isEncapsulatedDaysRentedEquals(int givenDaysRented){
        return daysRented == givenDaysRented;
    }

    private boolean isEncapsulatedCostEquals(double givenCost){
        return cost == givenCost;
    }

}