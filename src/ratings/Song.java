package ratings;

public class Song {
    private String Title;
    private String Artist;
    private String SongID;

    public String getTitle(){
        return this.Title;
    }

    public String getSongID(){
        return this.SongID;

    }
    public String getArtist(){
        return this.Artist;

    }
    public void setTitle(String Title){
        this.Title = Title;
    }

    public void setArtist(String Artist){
        this.Artist = Artist;

    }
    public void setSongID(String SongID){
        this.SongID = SongID;

    }

}