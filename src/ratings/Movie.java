package ratings;

import java.util.ArrayList;

public class Movie extends Ratable{
    private ArrayList<String> names;

    public Movie(String Title,ArrayList<String> names){
        super(Title);
        this.names = names;

    }

    public ArrayList<String> getCast(){
        return this.names;
    }


}
