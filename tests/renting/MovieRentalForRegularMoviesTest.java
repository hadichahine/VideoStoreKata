package renting;

import movie.Movie;
import movie.MovieType;
import movie.RegularMovie;
import org.junit.Before;
import org.junit.Test;
import rental.Rental;
import utils.TestRentalHelper;

import static org.junit.Assert.*;

public class MovieRentalForRegularMoviesTest {

    private Movie movie;

    @Before
    public void setup() throws Exception{
        movie = new RegularMovie("Dummy_Movie_Name");
    }

    @Test
    public void testRegularMovieRentalFor2Days() {
        Rental rental = TestRentalHelper.createRentalForMovie(movie,2);
        assertEquals(2,rental.value(),0.009);
    }

    @Test
    public void testRegularMovieRentalFor3Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(movie,3);
        assertEquals(2+(3-2)*1.5,rental.value(),0.009);
    }

    @Test
    public void testRegularMovieRentalFor4Days() {
        Rental rental = TestRentalHelper.createRentalForMovie(movie,4);
        assertEquals(2+(4-2)*1.5,rental.value(),0.009);
    }

    @Test
    public void testRegularMovieRentalFor8Days() {
        Rental rental = TestRentalHelper.createRentalForMovie(movie,8);
        assertEquals(2+(8-2)*1.5,rental.value(),0.009);
    }

}

