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

        assertTrue(test.size()> 1);

    }

    @Test
    public void testReadMovieRatingsMultipleRatings() {
        ArrayList<Movie> empty = FileReader.readMovies("data/moviestest1.csv");
        // Test empty input ArrayList
        ArrayList<Movie> test = FileReader.readMovieRatings(empty, "data/movie_ratingtest1.csv");
        for(Movie move: test){
            assertTrue(move.getRatings().size() > 1);
        }

    }

    @Test
    public void testReadMovieRatingsUnratedMovies() {
        ArrayList<Movie> empty = FileReader.readMovies("data/moviestest1.csv");
        // Test empty input ArrayList
        ArrayList<Movie> test = FileReader.readMovieRatings(empty, "data/movie_ratingtest2.csv");
        Movie movie = empty.get(0);

        assertFalse(test.contains(movie));



    }


    @Test
    public void testTopKRatable(){
        ArrayList<Song> songs = FileReader.readSongs("data/Ratings.csv");
        ArrayList<Movie> movietitle = FileReader.readMovies("data/movies.csv");
        ArrayList<Movie> movieArrayList = FileReader.readMovieRatings(movietitle,"movie_ratings.csv");

        MediaLibrary testing = new MediaLibrary();
        testing.populateLibrary("data/Ratings.csv","data/movies.csv","data/movie_ratings.csv");

        int k = 10;
        assertTrue(testing.topKRatables(k).size() == k );
    }

    @Test
    public void testTopKRatableContainsOnlySongs(){
        ArrayList<Song> songs = FileReader.readSongs("data/Ratings.csv");
        ArrayList<Movie> movietitle = FileReader.readMovies("data/movies.csv");
        ArrayList<Movie> movieArrayList = FileReader.readMovieRatings(movietitle,"movie_ratings.csv");

        MediaLibrary testing = new MediaLibrary();
        testing.populateLibrary("data/Ratings.csv","data/movies.csv","data/movie_ratings.csv");

        int k = 1000;
        assertTrue(testing.topKRatables(k).size() > songs.size());
    }

    @Test
    public void testTopKRatableContainsOnlyMovies(){
        ArrayList<Song> songs = FileReader.readSongs("data/Ratings.csv");
        ArrayList<Movie> movietitle = FileReader.readMovies("data/moviestest1.csv");
        ArrayList<Movie> movieArrayList = FileReader.readMovieRatings(movietitle,"movie_ratingstest1.csv");

        MediaLibrary testing = new MediaLibrary();
        testing.populateLibrary("data/Ratings.csv","data/moviestest1.csv","data/movie_ratingstest1.csv");

        int k = 1000;
        assertTrue(testing.topKRatables(k).size() > movietitle.size());
        assertTrue(testing.topKRatables(k).size() > movieArrayList.size());
    }

    @Test
    public void testTopKReverseOrder(){
        ArrayList<Song> songs = FileReader.readSongs("data/Ratings.csv");
        ArrayList<Movie> movietitle = FileReader.readMovies("data/moviestest1.csv");
        ArrayList<Movie> movieArrayList = FileReader.readMovieRatings(movietitle,"movie_ratingstest1.csv");

        MediaLibrary testing = new MediaLibrary();
        int k = 1000;
        testing.populateLibrary("data/Ratings.csv","data/moviestest3.csv","data/movie_ratingtest1.csv");

        for (int i = 0 ; i < movieArrayList.size();i++){
            assertEquals(movieArrayList.get(i).getTitle(),testing.topKRatables(k).get(i).getTitle());
        }
    }



}
