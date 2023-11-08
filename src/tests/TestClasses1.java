package tests;
import ratings.Rating;
import org.junit.Test;
import ratings.Song;
import ratings.Reviewer;

import static org.junit.Assert.*;

public class TestClasses1 {

    @Test
    public void Rating(){
        Rating t = new Rating("3452",3);
        t.setReviewerID(t.getReviewerID());
        t.setRating(t.getRating());

        assertEquals(3, t.getRating());
    }


    @Test
    public void Rating_Past_5(){
        Rating t = new Rating("421",100);
        t.setReviewerID(t.getReviewerID());
        t.setRating(100);

        assertEquals(-1, t.getRating());
    }

    @Test
    public void Rating_Cap_Constructor(){
        Rating t = new Rating("444",100);

        assertEquals(-1,t.getRating());

    }

    @Test
    public void Rating_Below_1(){
        Rating t = new Rating("3452",-5);
        t.setRating(t.getRating());
        t.setReviewerID(t.getReviewerID());

        assertEquals(-1, t.getRating());
    }

    @Test
    public void Rating_no_ID(){
        Rating t = new Rating("",3);
        t.setRating(t.getRating());
        t.setReviewerID(t.getReviewerID());

        assertTrue(t.getReviewerID().isBlank());


    }
    @Test
    public void Song(){
        Song t = new Song("Sticky","Drake","4921");
        t.setArtist("");
        t.setTitle("");
        t.setSongID("");

        assertTrue(t.getArtist().isBlank());
        assertTrue(t.getTitle().isBlank());
        assertTrue(t.getSongID().isBlank());
    }

    @Test
    public void Reviewer_rateSong_below_1(){
        Reviewer t = new Reviewer("26742");
        t.setReviewerID(t.getReviewerID());
        Rating h = t.rateSong(-6);



        assertEquals(-1,h.getRating());
    }

    @Test
    public void Reviewer_rateSong_above_5(){
        Reviewer t = new Reviewer("26742");
        t.setReviewerID(t.getReviewerID());
        Rating h = t.rateSong(100);


        assertEquals(-1,h.getRating());

    }

    @Test
    public void reviewer_no_ID(){
        Reviewer t = new Reviewer("46892");
        t.setReviewerID(t.getReviewerID());
        Rating h = t.rateSong(4);
        h.setReviewerID("");

        assertTrue(h.getReviewerID().isBlank());
    }


    @Test
    public void wrong_rating(){
        Reviewer t = new Reviewer("555");
        t.setReviewerID(t.getReviewerID());
        Rating h = t.rateSong(4);
        h.setRating(3);

        assertNotEquals(h.getRating(), t.rateSong(4).getRating());



    }


    @Test
    public void no_ID_RateSong(){
        Reviewer t = new Reviewer("55");
        t.setReviewerID(t.getReviewerID());
        Rating h = t.rateSong(4);
        h.setReviewerID("");

        assertNotEquals(h.getReviewerID(), t.rateSong(4).getReviewerID());

    }

    @Test
    public void bad_setter_Reviewer(){
        Reviewer t = new Reviewer("55");
        t.setReviewerID("");

        assertTrue(t.getReviewerID().isBlank());
    }
}