package invoice;

import purchase.Purchase;
import rental.Rental;

public interface RentalPurchaseAddable {

    void addMovieRental(Rental rental);
    void addMoviePurchase(Purchase purchase);

}
