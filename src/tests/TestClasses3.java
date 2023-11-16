package tests;
import ratings.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestClasses3 {
    @Test
    public void testReadMovieRatingsEmpty() {
        ArrayList<Movie> empty = new ArrayList<>();
        // Test empty input ArrayList
        ArrayList<Movie> test = FileReader.readMovieRatings(empty, "empty.csv");

        assertTrue(test.isEmpty());

    }

    @Test
    public void testReadMovieRatingsMultipleMovies() {
        ArrayList<Movie> empty = FileReader.readMovies("data/movies.csv");
        // Test empty input ArrayList
        ArrayList<Movie> test = FileReader.readMovieRatings(empty, "data/movie_ratings.csv");

        for(Movie movie: test){
            System.out.println(movie.getTitle());
        }

    }

}
