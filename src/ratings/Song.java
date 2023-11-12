package ratings;


public class Song extends Ratable {

    private String Artist;
    private String SongID;


    public Song(String Title,String Artist,String SongID){
        super(Title);
        this.Artist = Artist;
        this.SongID = SongID;
    }


    public String getArtist(){
        return this.Artist;

    }
    public void setArtist(String Artist){
        this.Artist = Artist;

    }

    public String getSongID(){
        return this.SongID;

    }
    public void setSongID(String SongID){
        this.SongID = SongID;

    }

// Linked List Methods






    public static void main(String[] args){
        Song t = new Song("SexyBack","Justin Timber","11434");
        t.setTitle(t.getTitle());
        t.setSongID(t.getSongID());
        t.setArtist(t.getArtist());


        Rating t0 = new Rating("5",-1);
        Rating t1 = new Rating("2",1);
        Rating t2 = new Rating("3",3);
        Rating t3 = new Rating("7",4);
       Rating t4 = new Rating("1",3);
       Rating t5 = new Rating("4",2);
        Reviewer t6 = new Reviewer("2");

        //System.out.println(t.getRatings());
        t.addRating(t0);
        //System.out.println(t.getRatings());
        t.addRating(t1);
        t.addRating(t2);
        t.addRating(t3);
        t.addRating(t4);
        t.addRating(t5);
        System.out.println(t.getRatings() +"\n");
        //System.out.println(t.averageRating());
        t.removeRatingByReviewer(t6);
        System.out.println(t.getRatings());



    }


}

