package tests;

import ratings.*;
import org.junit.Test;



import static org.junit.Assert.*;

public class TestDataStructures1 {


    @Test
    public void SongRatingAverageSmall(){

        Song test = new Song("SexyBack","Justin Timber","114");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",3);
        Rating t1 = new Rating("22",5);
        Rating t2 = new Rating("47",5);
        test.addRating(t3);
        test.addRating(t1);
        test.addRating(t2);

        assertEquals(4.33,test.averageRating(),0.01);

    }

    @Test
    public void SongRatingAverageBadEmpty(){

        Song test = new Song("SexyBack","Justin Timber","114");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());
        test.setRatings(null);

        assertEquals(0.0,test.averageRating(),0.001);


    }

    @Test
    public void SongLLSDELETEHEAD(){
        Song test = new Song("SexyBack","Justin Timber","1142");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t31 = new Rating("3",2);
        Rating t1 = new Rating("2",1);
        Rating t2 = new Rating("3",3);
        Rating t4 = new Rating("5",4);

        Reviewer t3= new Reviewer("3");
        Reviewer t30= new Reviewer("2");
        Reviewer t32= new Reviewer("3");
        Reviewer t35= new Reviewer("5");


        test.addRating(t31);
        test.addRating(t1);
        test.addRating(t2);
        test.addRating(t4);

        test.removeRatingByReviewer(t3);
        test.removeRatingByReviewer(t30);
        test.removeRatingByReviewer(t32);
        test.removeRatingByReviewer(t35);

        assertNull(test.getRatings());





    }

    @Test
    public void SongRatingAverageBadRating(){

        Song test = new Song("SexyBack","Justin Timber","114");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t3 = new Rating("7",21);
        Rating t1 = new Rating("22",3);
        Rating t2 = new Rating("47",3);
        Rating t0 = new Rating("5",100);
        Rating t4 = new Rating("1",22);
        Rating t5 = new Rating("4",-1);
        test.addRating(t3);
        test.addRating(t1);
        test.addRating(t2);
        test.addRating(t4);
        test.addRating(t0);
        test.addRating(t5);

        assertEquals(test.averageRating(),3,0.01);

    }
    @Test
    public void SongLLSDELETEEND(){
        Song test = new Song("SexyBack","Justin Timber","1142");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t0 = new Rating("5",2);
        Rating t1 = new Rating("2",1);
        Rating t2 = new Rating("7",3);
        Rating t4 = new Rating("3",4);

        Reviewer t3= new Reviewer("3");

        test.addRating(t0);
        test.addRating(t1);
        test.addRating(t2);
        test.addRating(t4);
        test.removeRatingByReviewer(t3);

        assertNull(test.getRatings().getElement(t4));




    }


    @Test
    public void SongLLSDUPES(){
        Song test = new Song("SexyBac1k","Justin Timber","1142");
        test.setTitle(test.getTitle());
        test.setSongID(test.getSongID());
        test.setArtist(test.getArtist());


        Rating t0 = new Rating("4",2);
        Rating t1 = new Rating("3",1);
        Rating t2 = new Rating("5",3);
        Rating t3 = new Rating("5",4);
        Rating t4 = new Rating("6",2);
        Reviewer t= new Reviewer("5");

        test.addRating(t0);
        test.addRating(t1);
        test.addRating(t2);
        test.addRating(t3);
        test.addRating(t4);


        test.removeRatingByReviewer(t);

        assertNull(test.getRatings().getElement(t2));
        assertNotNull(test.getRatings().getElement(t3));



    }

    @Test
    public void SongRatingAverage2(){

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

}
