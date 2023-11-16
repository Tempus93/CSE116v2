package ratings;

import java.util.ArrayList;


public class MediaLibrary {

    private final ArrayList<Ratable> ratable = new ArrayList<>();
    public MediaLibrary(){
    }

    public void populateLibrary(String songfile, String moviecastfile, String movieratingfile){
        ArrayList<Song> Songs = FileReader.readSongs(songfile);
        ArrayList<Movie> Moviecast = FileReader.readMovies(moviecastfile);
        ArrayList<Movie> Movieratings = FileReader.readMovieRatings(Moviecast,movieratingfile);

        for(Song song : Songs){
            Ratable ratableSong = new Ratable(song.getTitle());
            ratableSong.setRatings(song.getRatings());
            this.ratable.add(ratableSong);
        }
        for (Movie movie: Movieratings){
            Ratable ratableMovie = new Ratable(movie.getTitle());
            ratableMovie.setRatings(movie.getRatings());
            this.ratable.add(ratableMovie);

        }


    }

        public ArrayList<Ratable> topKRatables(int top){

        ArrayList<Ratable> ratableArrayList = this.ratable;
        if(top > ratableArrayList.size() ){
            top = ratableArrayList.size();
        }
        ratableArrayList.sort((o1, o2) -> {
            if(o1.bayesianAverageRating(2,3)> o2.bayesianAverageRating(2,3)){
                return -1;
            } else if (o1.bayesianAverageRating(2,3)< o2.bayesianAverageRating(2,3)) {
                return 1;
            }
            return 0;
        });


            return  new ArrayList<>(ratableArrayList.subList(0,top));


    }
}
