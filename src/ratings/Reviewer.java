package ratings;

public class Reviewer {
    private String reviewerID;
    public void setReviewerID(String reviewerID){
        this.reviewerID = reviewerID;
    }
    public String getReviewerID(){
        return this.reviewerID;
    }

    public Rating rateSong(int num){
        Rating obj = new Rating();
        obj.setRating(num);
        obj.setReviewerID(this.reviewerID);
        return obj;
    }



}