package ratings;

public class Song {
    private String Title;
    private String Artist;
    private String SongID;

    public Song(String Title,String Artist,String SongID){
        this.Title = Title;
        this.Artist = Artist;
        this.SongID = SongID;
    }

    public String getTitle(){
        return this.Title;
    }

    public void setTitle(String Title){
        this.Title = Title;
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
    public static void main(String[] args){
        Song t = new Song("SexyBack","Justin Timber","11432");
        t.setTitle(t.getTitle());
        t.setSongID(t.getSongID());
        t.setArtist(t.getArtist());

        System.out.print(t.getSongID() +'\n');
        System.out.print(t.getTitle()+'\n');
        System.out.print(t.getArtist() +'\n');
    }


}

