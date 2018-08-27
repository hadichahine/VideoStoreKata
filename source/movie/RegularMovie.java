package movie;

public class RegularMovie extends Movie{

    public RegularMovie(String movieName) {
        super(movieName);
    }

    @Override
    public double rentalCost(int daysRented) {
        if(daysRented > 2)
            return 2+(daysRented-2)*1.5;
        else return 2;
    }
}
