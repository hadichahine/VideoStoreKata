package renting;

import movie.ChildrenMovie;
import movie.Movie;
import org.junit.Before;
import org.junit.Test;
import rental.Rental;
import utils.TestRentalHelper;

import static org.junit.Assert.*;

public class MovieRentalForChildrenMoviesTest {

    private Movie childrenMovie;

    @Before
    public void setup() throws Exception{
        childrenMovie = new ChildrenMovie("Dummy_Movie_Name");
    }

    @Test
    public void testMovieRentalForChildrenMoviesWith3Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(childrenMovie,3);
        assertEquals(1.5,rental.value(),0.009);
    }

    @Test
    public void testMovieRentalForChildrenMoviesWith4Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(childrenMovie,4);
        assertEquals(1.5 + (4-3)*1.5,rental.value(),0.009);
    }

    @Test
    public void testMovieRentalForChildrenMoviesWith6Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(childrenMovie,6);
        assertEquals(1.5 + (6-3)*1.5,rental.value(),0.009);
    }

}
