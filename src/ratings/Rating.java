package ratings;

public class Rating {
    private String ID;
    private int Rating;

    public Rating(String ID, int Rating){
        this.ID = ID;
        if (Rating >= 1 && Rating <= 5){
           this.Rating = Rating;
        }else {
            this.Rating = -1;
        }
    }

    public void setReviewerID(String reviewerID){
            this.ID = reviewerID;
    }

    public void setRating(int Rating){

        if (Rating >= 1 && Rating <= 5){
            this.Rating = Rating;
        }
        else {
            this.Rating = -1;
        }
    }
    public String getReviewerID(){
        return this.ID;
    }
    public int getRating(){
        return this.Rating;
    }

    public static void main(String[] args) {
        Rating t = new Rating("35645",-5);
        t.setRating(t.getRating());
        t.setReviewerID(t.getReviewerID());
        System.out.print(t.getReviewerID() + "\n");
        System.out.print(t.getRating());


    }
}