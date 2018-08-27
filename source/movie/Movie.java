package movie;

public abstract class Movie {

    private String title;
    private PricingData pricing;

    public Movie(String movieTitle){
        this(movieTitle,new PricingData(0));
    }

    public Movie(String movieTitle, PricingData pricingData){
        title = movieTitle;
        pricing = pricingData;
    }

    public String getTitle() {
        return title;
    }

    public double saleCost() {
        return pricing.getSalePrice();
    }

    public abstract double rentalCost(int daysRented);

}
