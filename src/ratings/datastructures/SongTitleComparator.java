package ratings.datastructures;

import ratings.Song;


public class SongTitleComparator extends Comparator<Song>{
    @Override
    public boolean compare(Song a, Song b) {
        return a.getTitle().compareToIgnoreCase(b.getTitle()) < 0;
    }

}


