package tests;
import ratings.Rating;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClasses1 {

    @Test
    public void RatingPass5(){
        Rating t = new Rating();
        t.setRating(100);
        assertEquals(-1,Integer.parseInt(t.getRating()));
    }

    @Test
    public void RatingBelow1(){
        Rating t = new Rating();
        t.setRating(-2);
        assertEquals(-1,Integer.parseInt(t.getRating()));
    }

}