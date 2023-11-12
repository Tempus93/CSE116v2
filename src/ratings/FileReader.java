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
        ArrayList<Movie> movieArrayList;

        HashMap<String , Rating> movieHashMap = new HashMap<>();

        try {
            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));
            for (String line: Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                String reviewerID = splits.get(1);
                int ratings = Integer.parseInt(splits.get(2));

                if(!movieHashMap.containsKey(title)){
                    Rating rating = new Rating(reviewerID,ratings);
                    movieHashMap.put(title,rating);
                }
            }
            for(Map.Entry<String, Rating> entry: movieHashMap.entrySet()){
                for(Movie movie: Movies){
                    if (movie.getTitle().equalsIgnoreCase(entry.getKey())){
                        movie.addRating(entry.getValue());
                    }
                }
            }
            movieArrayList = Movies;

        }
        catch (IOException e){
            return new ArrayList<>();

        }



        return movieArrayList;
    }
}
