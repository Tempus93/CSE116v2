package tests;
import ratings.*;
import org.junit.Test;
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

}
