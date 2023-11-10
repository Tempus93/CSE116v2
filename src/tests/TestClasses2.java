package tests;
import ratings.*;
import org.junit.Test;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestClasses2 {
    @Test
    public void SongBayesianRating(){

        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,3),3.75,0.01);

    }

    @Test
    public void testBayNoRatings(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(0,3),4.5,0.01);

    }

    @Test
    public void testBayBadRatings(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(-1,3),0,0.01);

    }

    @Test
    public void testBayBadRatingsValuesLess(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,-2),0,0.01);

    }
    @Test
    public void testBayBadRatingsValuesMore(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,20),0,0.01);

    }

    @Test
    public void testBayBadRatingsEmpty(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());




        assertEquals(test.bayesianAverageRating(0,-2),0,0.01);

    }

    @Test
    public void testBayBadRatingsEmpty2(){
        Song test = new Song("SexyBack","Justin Timber","114");

        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());




        assertEquals(test.bayesianAverageRating(2,3),3,0.01);

    }

    @Test
    public void MovieBayesianRating(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Peter");
        cast.add("Tom");
        cast.add("Steven");
        cast.add("Betty");
        cast.add("Sophia");

        Movie test = new Movie("Jurassic Park",cast);

        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,3),3.75,0.01);

    }

    @Test
    public void MovieBayesianBadRating(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Peter");
        cast.add("Tom");
        cast.add("Steven");
        cast.add("Betty");
        cast.add("Sophia");

        Movie test = new Movie("Jurassic Park",cast);

        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(-2,3),0,0.01);

    }

    @Test
    public void MovieBayesianBadRatingValue(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Peter");
        cast.add("Tom");
        cast.add("Steven");
        cast.add("Betty");
        cast.add("Sophia");

        Movie test = new Movie("Jurassic Park",cast);

        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,30),0,0.01);

    }
    @Test
    public void MovieBayesianBadRatingValue2(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Peter");
        cast.add("Tom");
        cast.add("Steven");
        cast.add("Betty");
        cast.add("Sophia");

        Movie test = new Movie("Jurassic Park",cast);

        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(2,-20),0,0.01);

    }
    @Test
    public void MovieBayesianEmpty(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Peter");
        cast.add("Tom");
        cast.add("Steven");
        cast.add("Betty");
        cast.add("Sophia");

        Movie test = new Movie("Jurassic Park",cast);


        assertEquals(test.bayesianAverageRating(0,30),0,0.01);

    }
    @Test
    public void MovieBayesianBadRatingSize(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie test = new Movie("Jurassic Park",cast);

        Rating t3 = new Rating("7",4);
        Rating t1 = new Rating("22",5);
        test.addRating(t3);
        test.addRating(t1);


        assertEquals(test.bayesianAverageRating(-2,2),0,0.01);

    }


    @Test
    public void MovieGetTitle(){
        ArrayList<String> cast = new ArrayList<>();
        ArrayList<String> cast2 = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");


        cast2.add("Peter");
        cast2.add("Tom");
        cast2.add("Steven");


        Movie test = new Movie("Jurassic Park",cast);



        assertEquals("Jurassic Park",test.getTitle());

    }
    @Test
    public void MovieGetCaseMissing(){
        ArrayList<String> cast = new ArrayList<>();
        ArrayList<String> cast2 = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        cast2.add("Chris Pratt");
        cast2.add("Zoe Saldana");


        Movie test = new Movie("Jurassic Park",cast);


        assertTrue(test.getCast().size() != cast2.size());

    }
    @Test
    public void MovieGetCaseBadOrder(){
        ArrayList<String> cast = new ArrayList<>();
        ArrayList<String> cast2 = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        cast2.add("Dave Bautista");
        cast2.add("Zoe Saldana");
        cast2.add("Chris Pratt");


        Movie test = new Movie("Jurassic Park",cast);



        for(int i = 0; i < test.getCast().size();i++){
            if (!cast2.get(i).equalsIgnoreCase(test.getCast().get(i))){
                assertFalse(cast2.get(i).equalsIgnoreCase(test.getCast().get(i)));

            }else {
                assertTrue(cast2.get(i).equalsIgnoreCase(test.getCast().get(i)));
            }
        }

    }
    @Test
    public void MovieGetCaseTwoNames() {
        ArrayList<String> cast = new ArrayList<>();
        ArrayList<String> cast2 = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");



        Movie test = new Movie("Jurassic Park", cast);

        cast2.add("Chris Pratt");
        cast2.add("Zoe Saldana");


        assertEquals(cast2.size(), test.getCast().size());
        for(int i = 0; i < test.getCast().size();i++){
            assertTrue(cast2.get(i).equalsIgnoreCase(test.getCast().get(i)));
        }
   }

}

