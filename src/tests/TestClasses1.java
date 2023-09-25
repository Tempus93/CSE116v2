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
    public void RatingPass5(){
        Rating t = new Rating("3452",100);
        t.setReviewerID(t.getReviewerID());
        t.setRating(t.getRating());

        assertEquals(-1, t.getRating());
    }

    @Test
    public void RatingBelow1(){
        Rating t = new Rating("3452",-5);
        t.setRating(t.getRating());

        assertEquals(-1, t.getRating());
    }
    @Test
    public void Song(){
        Song t = new Song("Sticky","Drake","4921");
        t.setArtist(t.getArtist());
        t.setTitle(t.getTitle());
        t.setSongID(t.getSongID());

        assertEquals("Drake", t.getArtist());
        assertEquals("Sticky", t.getTitle());
        assertEquals("4921", t.getSongID());
    }

    @Test
    public void Reviewer(){
        Reviewer t = new Reviewer("26742");
        t.setReviewerID(t.getReviewerID());


        assertEquals(t.getReviewerID(),"26742");
    }

    @Test
    public void RatingReviewerID(){
        Rating t = new Rating("35115",4);
        t.setReviewerID(t.getReviewerID());

        assertEquals("35115", t.getReviewerID());
    }
}