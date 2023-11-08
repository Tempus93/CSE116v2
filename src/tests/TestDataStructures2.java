package tests;

import ratings.*;
import org.junit.Test;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {
    SongTitleComparator titleComparator = new SongTitleComparator();
    SongBayesianRatingComparator bayesianRatingComparator = new SongBayesianRatingComparator();

    @Test
    public void BSTTEST(){

        Playlist list = new Playlist(titleComparator);
        Song test = new Song("SexyBack","1140","Justin Timber");
        Song test1 = new Song("SeaxyBack","1141","Justin Timber");
        Song test2 = new Song("SeexyBack","1142","Justin Timber");
        Song test3 = new Song("SxxyBack","1143","Justin Timber");

        list.addSong(test1);
        list.addSong(test);
        list.addSong(test3);
        list.addSong(test2);

        System.out.println(list.getSongList());System.out.println(list.getSongList());System.out.println(list.getSongList());
    }

    @Test
    public void PlaylistMoreThan3Songs(){
        Playlist actual = new Playlist(titleComparator);
        Playlist expected = new Playlist(titleComparator);
        Song test = new Song("SexyBack","1140","Justin Timber");
        Song test1 = new Song("SeaxyBack","1141","Justin Timber");
        Song test2 = new Song("SeexyBack","1142","Justin Timber");
        Song test3 = new Song("SxxyBack","1143","Justin Timber");

        actual.addSong(test);expected.addSong(test);
        actual.addSong(test1);expected.addSong(test1);
        actual.addSong(test2);expected.addSong(test2);
        actual.addSong(test3);expected.addSong(test3);

        assertTrue(actual.getSongList().size() > 3);
        assertEquals(actual.getSongList().getValue(),expected.getSongList().getValue());





    }

    public void Reverse(LinkedListNode<Song> a , LinkedListNode<Song> b){
        if(a == null){
            assertNull(b);
        }
        else {
            assertNotNull(b);
            assertEquals(a.size(),b.size());
            assertEquals(a.getValue(), b.getValue());
            Reverse(a.getNext(),b.getNext());
        }
    }


    @Test
    public void PlaylistReversed(){
        Playlist actual = new Playlist(titleComparator);
        Song test = new Song("Cry","1140","Justin Timber");
        Song test1 = new Song("Holy","1141","Justin Timber");
        Song test2 = new Song("SexyBack","1142","Justin Timber");
        LinkedListNode<Song> Expected = new LinkedListNode<>(test,null);
        Expected.append(test1);
        Expected.append(test2);

        actual.addSong(test2);
        actual.addSong(test1);
        actual.addSong(test);


        Reverse(Expected,actual.getSongList());





    }

    @Test
    public void PlaylistMissingSong(){
        Playlist actual = new Playlist(titleComparator);
        Song test = new Song("SexyBack","1140","Justin Timber");
        Song test1 = new Song("SeaxyBack","1141","Justin Timber");
        Song test2 = new Song("SeexyBack","1142","Justin Timber");
        LinkedListNode<Song> expected = new LinkedListNode<>(test,null);

        actual.addSong(test);expected.append(test1);
        actual.addSong(test1);expected.append(test2);

        assertTrue(expected.size() > actual.getSongList().size());

    }
}




