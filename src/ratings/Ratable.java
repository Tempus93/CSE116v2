package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {

    private String Title;
    private LinkedListNode<Rating> LLS;

    public Ratable(String Title){
        this.Title = Title;

    }

    public String getTitle(){
        return this.Title;
    }

    public void setTitle(String Title){
        this.Title = Title;
    }


    // Linked List Methods
    public void addRating(Rating obj){
        if(this.LLS != null){
            this.LLS.append(obj);
        }
        else {
            this.LLS = new LinkedListNode<>(obj,null);
        }
    }

    public LinkedListNode<Rating> getRatings(){
        if(this.LLS == null){
            return null;
        }
        else{
            return this.LLS;
        }
    }

    public void setRatings(LinkedListNode<Rating> obj){
        this.LLS = obj;

    }
    // Task 3


    public double averageRating() {
        if (this.LLS == null) {
            return 0.0;
        }
        else{
            double sum = 0.0;
            double size = 0.0;
            LinkedListNode<Rating> temp = this.LLS;

            while (temp != null){
                if(temp.getValue().getRating() != -1){
                    sum += temp.getValue().getRating();
                    size ++;
                }
                temp = temp.getNext();
            }
            return sum/size;
        }
    }

    public void removeRatingByReviewer(Reviewer obj){
        String ID = obj.getReviewerID();
        LinkedListNode<Rating> temp;

        if(this.LLS.getValue().getReviewerID().equals(ID)) {
            temp = this.LLS;
            this.LLS = temp.getNext();
        }else {
            LinkedListNode<Rating> current = this.LLS;
            while (current.getNext() != null){

                if(current.getNext().getValue().getReviewerID().equals(ID)){
                    current.setNext(current.getNext().getNext());
                    break;
                }
                else {
                    current = current.getNext();
                }
            }
        }
    }

    public double bayesianAverageRating(int ratings,int value){
        if(value > 5 || value < 1 || ratings < 0){
            return 0.0;
        }
        if(this.LLS == null && ratings == 0){
            return 0.0;
        }
        else {
            double sum = 0.0;
            double size = 0.0;
            LinkedListNode<Rating> temp = this.LLS;

            while (temp != null){
                if(temp.getValue().getRating() != -1){
                    sum += temp.getValue().getRating();
                    size ++;
                }
                temp = temp.getNext();
            }
            for(int i = 0; i < ratings;i++){
                sum += value;
                size++;
            }

            return sum/size;

        }

    }





}
