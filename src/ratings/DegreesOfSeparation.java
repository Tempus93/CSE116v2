package ratings;

import ratings.datastructures.Graph;
import ratings.datastructures.Queue;

import java.util.*;

public class DegreesOfSeparation {
    private final ArrayList<Movie> movies;
    public DegreesOfSeparation(ArrayList<Movie> movie){
        this.movies = movie;
    }

    public int degreesOfSeparation(String name1, String name2){

        String actor1 = "";
        String actor2 = "";
        Graph<String> Trace = new Graph<>();

        for(Movie movie : movies) {
            if (movie.getCast().contains(name1)) {
                actor1 = name1;
            }
            if (movie.getCast().contains(name2)) {
                actor2 = name2;
            }
        }
        if(actor1.equalsIgnoreCase(actor2)){
            return 0;
        }
        if (actor1.isEmpty() || actor2.isEmpty()){
            return -1;
        }

        //Build the graph
        for(Movie movie: movies){
            for(String s : movie.getCast()){
                if(!s.isEmpty()){
                    for (String s2: movie.getCast()){
                        if(!s2.equalsIgnoreCase(s) && !s2.isEmpty()){
                            Trace.addEdge(s,s2);
                        }
                    }

                }
            }
        }


        //BFS
        Queue<String> queue = new Queue<>();
        ArrayList<String> visited = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        queue.enqueue(actor1);
        map.put(actor1,0);


        while (!queue.toString().isEmpty()) {
            String x = queue.dequeue();

            if(!visited.contains(x)){
                visited.add(x);

                for (String s : Trace.getAdjacencyList().get(x)) {
                    int subDegree = map.get(x)+1;
                    if (!map.containsKey(s)) {
                        map.put(s, subDegree);
                        queue.enqueue(s);
                    }
                }
            }
            if(map.containsKey(actor2)){
                return map.get(actor2);
            }


        }





        return -1;
    }

}
