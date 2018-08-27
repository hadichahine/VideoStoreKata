package movie;

public class DiscountDecorator extends Movie{

    private Movie discountableMovie;
    private double rentalDiscountPercentage,
            purchaseDiscountPercentage;

    public DiscountDecorator(Movie movie,double rentalDiscountPercentage,double purchaseDiscountPercentage){
        super(movie.getTitle());
        this.rentalDiscountPercentage = rentalDiscountPercentage;
        this.purchaseDiscountPercentage = purchaseDiscountPercentage;
        discountableMovie = movie;
    }

    @Override
    public double saleCost(){
        return discountPercentageFrom(discountableMovie.saleCost(),purchaseDiscountPercentage);
    }

    @Override
    public double rentalCost(int daysRented) {
        return discountPercentageFrom(discountableMovie.rentalCost(daysRented),rentalDiscountPercentage);
    }

    private double discountPercentageFrom(double value, double percentage){
        return value * (1 - percentage/100);
    }

}
