package ratings;

import ratings.datastructures.BST;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {


    private BST<Song> bst;
    private LinkedListNode<Song> LLS;

    public Playlist(Comparator<Song> Song){
        this.bst = new BST<>(Song);

    }

    public void addSong(Song a){
        bst.insert(a);

    }

    public BinaryTreeNode<Song> getSongTree() {
        return bst.getRoot();
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> tree){

        if (tree != null) {
            getSongList(tree.getLeft());

            if(this.LLS != null){
                while(this.LLS.getElement(tree.getValue()) == null){
                    this.LLS.append(tree.getValue());
                 }
            }
            else {
                this.LLS = new LinkedListNode<>(tree.getValue(), null);
            }
            getSongList(tree.getRight());
        }
        return this.LLS;
    }

 public LinkedListNode<Song> getSongList(){
        return getSongList(this.bst.getRoot());
    }
}
