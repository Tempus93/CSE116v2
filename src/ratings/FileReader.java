package ratings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//test

public class FileReader {

    public static ArrayList<Song> readSongs(String filename) {
        ArrayList<Song> SongList = new ArrayList<>();

        try {

            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));

            HashMap<String, Song> songHashMap = new HashMap<>(); // hashmap to track songs & stop dupes

            for(String line:Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String songID = splits.get(0);
                String artist = splits.get(1);
                String title = splits.get(2);
                String reviewerID = splits.get(3);
                int rating = Integer.parseInt(splits.get(4));

                // prevent dupe SpotifyIDs in array
                if(!songHashMap.containsKey(songID)){
                    Song song = new Song(songID,artist,title);
                    SongList.add(song);
                    songHashMap.put(songID,song);
                }
                songHashMap.get(songID).addRating(new Rating(reviewerID,rating));
            }
        }
        catch (IOException e) {
            return new ArrayList<>();
        }

        return SongList;
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
}
