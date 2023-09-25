package ratings;

public class Reviewer {
    private String ReviewerID;

    public  Reviewer(String ReviewerID){
        this.ReviewerID = ReviewerID;
    }

    public String getReviewerID(){
        return ReviewerID;
    }
    public void setReviewerID(String reviewerID){
        this.ReviewerID = reviewerID;

    }
    public Rating rateSong(int num){

        return new Rating(this.ReviewerID,num);

    }

    public static void main(String[] args){
        Reviewer joke = new Reviewer("4321");
        joke.setReviewerID(joke.getReviewerID());
        System.out.print(joke.getReviewerID() + "\n");
        System.out.print(joke.rateSong(4));



    }


}