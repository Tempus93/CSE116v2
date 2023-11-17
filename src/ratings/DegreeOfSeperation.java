package ratings;

import java.util.ArrayList;

public class DegreeOfSeperation {
    private ArrayList<Movie> movies;
    public DegreeOfSeperation(ArrayList<Movie> movie){
        this.movies = movie;
    }

    public int degreeOfSeperation(String name1, String name2){
        String actor1 = "";
        String actor2 = "";

        //Checks if actors is in movie
        for(Movie movie: movies){
            for(String actor: movie.getCast()){
                if(actor.equalsIgnoreCase(name1)){
                    actor1 = actor;
                }

                if (actor.equalsIgnoreCase(name2)) {
                    actor2 = actor;
                }
            }
        }

        //checks if either name wasn't found or Same Name
        if(actor1.isEmpty()||actor2.isEmpty()){
            return -1;
        } else if (actor1.equalsIgnoreCase(actor2)) {
            return 0;
        }


    }
}
