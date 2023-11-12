package tests;

import org.junit.Assert;
import ratings.*;
import org.junit.Test;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestFiles {

     String ratings1 = "data/Test1.csv";
    String moviebad = "data/moviebadtitle.csv";
     String ratingsWrongOrder = "data/ratingWrongOrder.csv";
     String rating1rating = "data/ratings1song.csv";

     String Movies1 = "data/moviestest1.csv";

     String Empty = "data/empty.csv";

     @Test
     public void Movies(){
         ArrayList<Movie> Expected = FileReader.readMovies("data/moviestest2.csv");
         ArrayList<Movie> Actual = new ArrayList<>();
         ArrayList<String> movie1 = new ArrayList<>();
         ArrayList<String> movie2 = new ArrayList<>();
         movie1.add("James");
         movie1.add("Daxter");
         movie1.add("Johnny");
         movie2.add("El Chapo");
         movie2.add("Diamond");
         movie2.add("DXD");
         Movie Toy = new Movie("Toy Story",movie1);
         Movie Sleep = new  Movie("Sleeping Dogs",movie2);

         Actual.add(Toy);
         Actual.add(Sleep);

         assertEquals(Expected.size(),Actual.size());

     }

     @Test
     public void moviefilenotfound(){
         ArrayList<Movie> Actual = FileReader.readMovies(Empty);

         assertEquals(0,Actual.size());

     }

     @Test
     public void movie_bad_title(){

         ArrayList<Movie> Actual = FileReader.readMovies(Movies1);
         ArrayList<String> Expected = new ArrayList<>();
         ArrayList<Movie> Expected2 = FileReader.readMovies(Movies1);

         Expected.add("Toy Story");
         Expected.add("Sleeping Dogs");
         Expected.add("LA");

         if(!Actual.isEmpty()){
             for (Movie movie : Actual) {
                 assertTrue(Expected.contains(movie.getTitle()));
             }
         }
     }

    @Test
     public void movie_bad_order(){
         ArrayList<Movie> Actual = FileReader.readMovies("data/movies1badorder.csv");
         ArrayList<String> Expected = new ArrayList<>();

         Expected.add("James");
         Expected.add("Daxter");
         Expected.add("Johnny");


        if(!Actual.isEmpty()){
            for(int i = 0; i < Actual.get(0).getCast().size();i++){
                assertFalse(Expected.get(i).equalsIgnoreCase(Actual.get(0).getCast().get(i)));
            }
        }






     }

     @Test
     public void movie_max_2(){
         ArrayList<Movie> Actual = FileReader.readMovies("data/movies.csv");

         assertTrue(Actual.size() > 2);
     }

    @Test
    public void Ratings() {
        ArrayList<Song> Song = FileReader.readSongs(ratings1);

        Song t1 = new Song("1", "James", "Time");
        Song t2 = new Song("26", "James Baxter", "Go Time");
        Song t3 = new Song("689", "James Dexter", "Murder Time");

        ArrayList<Song> Actual = new ArrayList<>();
        Actual.add(t1);
        Actual.add(t2);
        Actual.add(t3);

        try {
            assertEquals(Actual.size(), Song.size());

        }catch (ArrayIndexOutOfBoundsException e){
            assertEquals(Actual.size(), Song.size());
        }
    }



    @Test
    public void Rating_Single_1(){
        ArrayList<Song> Actual = FileReader.readSongs(rating1rating);
        Song t1 = new Song("1", "James", "Time");
        Song t2 = new Song("26", "James Baxter", "Go Time");
        Song t3 = new Song("689", "James Dexter", "Murder Time");
        t1.addRating(new Rating("242",4));
        t2.addRating(new Rating("291",2));
        t3.addRating(new Rating("29",3));

        ArrayList<Song> Expected = new ArrayList<>();
        Expected.add(t1);
        Expected.add(t2);
        Expected.add(t3);

        if(!Actual.isEmpty()){
            for (Song song : Actual) {
                assertTrue(song.getRatings().size() > 1);
            }
        }


    }

    @Test
    public void Song_Rating_Wrong_Order(){
        ArrayList<Song> Actual = FileReader.readSongs(ratingsWrongOrder);
        ArrayList<Integer> Expected = new ArrayList<>();

        Song t1 = new Song("1", "James", "Time");

        t1.addRating(new Rating("22",3));
        t1.addRating(new Rating("27",1));
        t1.addRating(new Rating("242",4));


        Expected.add(3);
        Expected.add(1);
        Expected.add(4);

        if(!Actual.isEmpty()) {
            for (Song song : Actual) {
                try {
                    if (song.getRatings() != null) {
                        assertNotNull(song.getRatings());
                        for (Integer integer : Expected) {
                            assertNotEquals((int) integer, song.getRatings().getValue().getRating());
                            song.setRatings(song.getRatings().getNext());
                        }
                    }
                    else if (song.getRatings() == null) {
                        assertNull(song.getRatings());
                    }
                }
                catch (NullPointerException e){
                    assertNull(song.getRatings());
                }
            }

        }
     }

     @Test
     public void Song_Bad_title(){
         ArrayList<Song> Actual = FileReader.readSongs(ratingsWrongOrder);
         ArrayList<String> Expected = new ArrayList<>();


         Expected.add("Time");

         if(!Actual.isEmpty()){
             for (Song song : Actual) {
                 assertTrue(Expected.contains(song.getTitle()));
             }
         }
     }

     @Test
     public void Song_bad_ReviewerID(){
             ArrayList<Song> Actual = FileReader.readSongs(ratingsWrongOrder);
             ArrayList<String> Expected = new ArrayList<>();


             Expected.add("22");
             Expected.add("27");
             Expected.add("242");
            try {
                if(!Actual.isEmpty()){
                    for (Song song : Actual) {
                        assertTrue(Expected.contains(song.getRatings().getValue().getReviewerID()));
                    }
                }

            }catch (ArrayIndexOutOfBoundsException e){
                if(!Actual.isEmpty()){
                    for (Song song : Actual) {
                        assertTrue(Expected.contains(song.getRatings().getValue().getReviewerID()));
                    }
                }

            }
     }

     @Test
     public void Song_bad_Artist(){
         ArrayList<Song> Actual = FileReader.readSongs(ratingsWrongOrder);
         ArrayList<String> Expected = new ArrayList<>();


         Expected.add("James");


         if(!Actual.isEmpty()){
             for (Song song : Actual) {
                 assertTrue(Expected.contains(song.getArtist()));
             }
         }
     }


    @Test
    public void RatingsEmpty(){
        ArrayList<Song> Song = FileReader.readSongs(Empty);

        assertEquals(0,Song.size());

    }
}
