package tests;

import org.junit.Test;
import ratings.ProblemSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.*;

public class TestProblemSet {

    @Test
    public void testAverageSingleton(){
        ArrayList<Double> taverage = new ArrayList<>();

        taverage.add(1.0);

        assertEquals(1.0, ProblemSet.average(taverage), 0.001);
    }


    @Test
    public void testAverage(){
        ArrayList<Double> taverage = new ArrayList<>();

        taverage.add(1.0);
        taverage.add(2.0);
        taverage.add(3.0);

        assertEquals(2.0, ProblemSet.average(taverage), 0.001);
    }
    @Test
    public void testAverageSumEqualsZero(){
        ArrayList<Double> taverage = new ArrayList<>();

        taverage.add(-5.0);
        taverage.add(5.0);

        assertEquals(0.0, ProblemSet.average(taverage),0.001);
    }

    @Test
    public void testAverageEmpty() {
        ArrayList<Double> taverage = new ArrayList<>();

        assertEquals(0.0, ProblemSet.average(taverage),0.001);
    }

    @Test
    public void testaverageLargelist(){
        ArrayList<Double> taverage = new ArrayList<>();

        taverage.add(6.5);
        taverage.add(6.5);
        taverage.add(8.5);
        taverage.add(8.5);



        assertEquals(7.5, ProblemSet.average(taverage),0.001);
    }
    @Test
    public void testaverageLargelist2() {
        ArrayList<Double> taverage = new ArrayList<>();

        taverage.add(6.5);taverage.add(6.5);
        taverage.add(8.5);taverage.add(8.5);
        taverage.add(6.2);taverage.add(10.7);
        taverage.add(9.2);taverage.add(9.5);
        taverage.add(6.5);taverage.add(9.2);
        taverage.add(3.4);taverage.add(8.5);
        taverage.add(3.8);taverage.add(10.7);
        taverage.add(9.2);taverage.add(9.5);


        assertEquals(7.9, ProblemSet.average(taverage),0.001);
    }
    @Test
    public void testSum(){
        assertEquals(6, ProblemSet.sumOfDigits(123));
        assertEquals(12, ProblemSet.sumOfDigits(57));
        assertEquals(9, ProblemSet.sumOfDigits(-36));

    }

    @Test
    public void testbestKey() {
        HashMap<String, Integer> best = new HashMap<>();
        best.put("CSE", 100);
        best.put("MTH", 90);
        best.put("MGT", 10);

        assertEquals("CSE", ProblemSet.bestKey(best));

    }

    @Test
    public void testbestKeyMultiples() {
        HashMap<String, Integer> best = new HashMap<>();
        best.put("dog", 5);
        best.put("ear", 5);
        best.put("fox", 4);


        assertTrue(Objects.equals(ProblemSet.bestKey(best), "dog") || Objects.equals(ProblemSet.bestKey(best), "ear"));

    }

    @Test
    public void testbestKeyNegatives() {
        HashMap<String, Integer> best = new HashMap<>();
        best.put("dog", -5); best.put("cat", -2); best.put("fox", -4);

        assertEquals("cat", ProblemSet.bestKey(best));
        // TOD0: Write testing for all 3 methods of the ratings.ProblemSet class

    }

    @Test
    public void testbestKeyEmpty() {
        HashMap<String, Integer> best = new HashMap<>();

        assertEquals("", ProblemSet.bestKey(best));
        // TOD0: Write testing for all 3 methods of the ratings.ProblemSet class

    }
}