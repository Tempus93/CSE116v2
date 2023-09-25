package tests;
import ratings.Rating;
import org.junit.Test;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.*;

public class TestClasses1 {

    @Test
    public void Rating(){
        Rating t = new Rating();
        t.setRating(3);
        assertEquals(3,t.getRating());
    }


    @Test
    public void RatingPass5(){
        Rating t = new Rating();
        t.setRating(100);
        assertEquals(-1,t.getRating());
    }

    @Test
    public void RatingBelow1(){
        Rating t = new Rating();
        t.setRating(-2);
        assertEquals(-1,t.getRating());
    }
    @Test
    public void Song(){
        Song obj = new Song();
        obj.setArtist("Drake");
        obj.setTitle("Sticky");
        obj.setSongID("2591214");
        System.out.print(obj.getArtist()+ "\n");
        System.out.print(obj.getTitle() + "\n");
        System.out.print(obj.getSongID()+ "\n");
    }

    // Testing Commit & Push

    @Test
    public void RatingReviewerID(){
        Rating t = new Rating();
        t.setReviewerID("149345");
        System.out.print(t.getReviewerID());
    }

    @Test
    public void Reviewer(){
        Reviewer t = new Reviewer();
        t.setReviewerID("36932");

        System.out.println(t.getReviewerID()+ "\n");
        System.out.println(t.rateSong(6) + "\n");
    }
}