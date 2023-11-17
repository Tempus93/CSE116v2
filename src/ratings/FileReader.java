package ratings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//test

public class FileReader {

    public static ArrayList<Song> readSongs(String filename) {
        ArrayList<Song> SongList = new ArrayList<>();

        try {

            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));

            HashMap<String, Song> songHashMap = new HashMap<>(); // hashmap to track songs & stop dupes


            for(String line:Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                String artist = splits.get(1);
                String songID = splits.get(2);
                String reviewerID = splits.get(3);
                int rating = Integer.parseInt(splits.get(4));

                // prevent dupe SpotifyIDs in array
                if(!songHashMap.containsKey(songID)){
                    Song song = new Song(songID,artist,title);
                    songHashMap.put(songID,song);
                }
                songHashMap.get(songID).addRating(new Rating(reviewerID,rating));
            }
            for(Map.Entry<String, Song> entry: songHashMap.entrySet()){
                SongList.add(entry.getValue());
            }

                return SongList;
        }
        catch (IOException e) {
            return new ArrayList<>();
        }

    }

    public static ArrayList<Movie> readMovies(String filename){
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        try {

            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));

            for (String line: Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));

                String movieTitle = splits.get(0);
                ArrayList<String> cast = new ArrayList<>();
                for(int i = 1; i < splits.size();i++){
                    cast.add(splits.get(i));
                }
                Movie movie = new Movie(movieTitle,cast);
                movieArrayList.add(movie);
            }
        }
        catch (IOException e){
            return new ArrayList<>();
        }

        return movieArrayList;
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> Movies, String filename){
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        HashMap<String , ArrayList<Rating>> movieHashMap = new HashMap<>();

        try {
            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));
            for (String line: Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                String reviewerID = splits.get(1);
                int ratings = Integer.parseInt(splits.get(2));

                if(!movieHashMap.containsKey(title)){
                    ArrayList<Rating> ratingArrayList = new ArrayList<>();
                    ratingArrayList.add(new Rating(reviewerID,ratings));
                    movieHashMap.put(title,ratingArrayList);
                }else{
                    movieHashMap.get(title).add(new Rating(reviewerID,ratings));

                }
            }
            for(Movie movie: Movies){
                for(Map.Entry<String, ArrayList<Rating>> entry: movieHashMap.entrySet()){
                    if (movie.getTitle().equalsIgnoreCase(entry.getKey())){
                        for (Rating rating: entry.getValue()){
                            movie.addRating(rating);
                        }
                        movieArrayList.add(movie);
                    }
                }
            }
        }
        catch (IOException e){
            return new ArrayList<>();

        }



        return movieArrayList;
    }
}
