package ratings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//test

public class FileReader {

    public static ArrayList<Song> readSong(String filename) {
        ArrayList<Song> SongList = new ArrayList<>();


        try {

            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));
            Lines.remove(0); // used to remove header

            HashMap<String, Song> songHashMap = new HashMap<>(); // hashmap to track songs & stop dupes

            for(String line:Lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String SpotifyID = splits.get(0);
                String Artist = splits.get(1);
                String Title = splits.get(2);
                String ReviewerID = splits.get(3);
                int Rating = Integer.parseInt(splits.get(4));

                // prevent dupes in array
                if(!songHashMap.containsKey(SpotifyID)){
                    Song song = new Song(SpotifyID,Artist,Title);
                    SongList.add(song);
                    songHashMap.put(SpotifyID,song);
                }
                songHashMap.get(SpotifyID).addRating(new Rating(ReviewerID,Rating));
            }

        }
        catch (IOException e) {
            return new ArrayList<>();
        }

        return SongList;
    }

    public static ArrayList<Movie> readMovie(String filename){
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        try {

            ArrayList<String> Lines = new ArrayList<>(Files.readAllLines((Paths.get(filename))));
            Lines.remove(0); // used to remove header

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
