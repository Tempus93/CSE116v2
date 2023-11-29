package tests;
import ratings.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDataStructures3 {

    @Test
    public void DegreeOfSeparationEmpty(){
        DegreesOfSeparation test = new DegreesOfSeparation(FileReader.readMovies("data/movies.csv"));

        test.degreesOfSeparation("Chris Pratt","Kevin Bacon");

        assertEquals(-1,test.degreesOfSeparation("Empty","Chris Pratt"));

    }
    @Test
    public void DegreeOfSeparationZero(){
        DegreesOfSeparation test = new DegreesOfSeparation(FileReader.readMovies("data/movies.csv"));

        test.degreesOfSeparation("Chris Pratt","Chris Pratt");

        assertEquals(0,test.degreesOfSeparation("Chris Pratt","Chris Pratt"));

    }

    @Test
    public void DegreeOfSeparationMoreThanOne(){
        DegreesOfSeparation test = new DegreesOfSeparation(FileReader.readMovies("data/movies.csv"));

        test.degreesOfSeparation("Chris Pratt","Chris Pratt");

        assertTrue(test.degreesOfSeparation("Chris Pratt","Tom Hanks") > 1);

    }
}
