package ratings;

public class Rating {
    private String ID;
    private int Rating;

    public void setReviewerID(String ID){
        this.ID = ID;
    }
    public void setRating(int Rating){
        if (Rating >= 1 && Rating <= 5){
            this.Rating = Rating;
        }else {
            this.Rating = -1;
        }
    }
    public String getReviewerID(){
        return this.ID;
    }
    public int getRating(){
        return this.Rating;
    }

    public static void main(String[] args){
        Rating J = new Rating();


    }
}