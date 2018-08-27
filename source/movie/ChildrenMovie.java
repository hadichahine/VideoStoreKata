package movie;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String movieName) {
        super(movieName);
    }

    @Override
    public double rentalCost(int daysRented) {
        if (daysRented < 3)
            return 1.5;
        return 1.5 + (daysRented-3)*1.5;
    }
}
