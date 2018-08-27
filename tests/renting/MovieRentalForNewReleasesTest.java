package renting;

import com.sun.org.apache.regexp.internal.RE;
import movie.Movie;
import movie.MovieType;
import movie.NewReleaseMovie;
import org.junit.Before;
import org.junit.Test;
import rental.Rental;
import utils.TestRentalHelper;

import static org.junit.Assert.*;

public class MovieRentalForNewReleasesTest {

    private Movie movie;

    @Before
    public void setup() throws Exception{
        movie = new NewReleaseMovie("Dummy_Movie_Name");
    }

    @Test
    public void testNewReleaseMovieRentalFor3Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(movie,3);
        assertEquals(3*3, rental.value(),0.009);
    }

    @Test
    public void testNewReleaseMovieRentalFor4Days(){
        Rental rental = TestRentalHelper.createRentalForMovie(movie,4);
        assertEquals(4*3,rental.value(),0.009);
    }

}
