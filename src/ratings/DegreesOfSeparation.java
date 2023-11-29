package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DegreesOfSeparation {
    private ArrayList<Movie> movies;
    public DegreesOfSeparation(ArrayList<Movie> movie){
        this.movies = movie;
    }

    public int degreesOfSeparation(String name1, String name2){
        String actor1 = "";
        String actor2 = "";
        int Degree = 1;



        //Checks if actors is in any movie
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
        if(actor1.isEmpty()|| actor2.isEmpty()){
            return -1;
        } else if (actor1.equalsIgnoreCase(actor2)) {
            return 0;
        }

        // perform breath-First Search
        ArrayList<String> current = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        HashMap<String, Integer> Map  = new HashMap<>();
        current.add(actor1);
        visited.add(actor1);
        Map.put(actor1,0);



        while (!current.isEmpty()){

           ArrayList<String> actorholder = new ArrayList<>();

            for(String cact: current){
                for (Movie movie : movies){
                    if (movie.getCast().contains(cact)){
                        for(String actor : movie.getCast()){
                            if(!visited.contains(actor)){
                                if(!Map.containsKey(actor)){
                                    Map.put(actor,Degree);
                                }
                                if (actor.equalsIgnoreCase(actor2)){
                                    return Map.get(actor);
                                }
                                visited.add(actor);
                                actorholder.add(actor);
                            }
                        }
                    }
               }
               Degree++;
               current = actorholder;
           }

       }

    return -1;
    }
}
