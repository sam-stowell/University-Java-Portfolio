package CIS2206.Unit_12;
import java.util.Collections;
import java.util.LinkedList;
public class Paper{
    String id;
    String title;
    String author;
    LinkedList<Review> reviewList;

    public Paper(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.reviewList = new LinkedList<Review>();
    }

    public void addReview(Review review) {
        reviewList.add(review);
        orderReviewsByScore();
        System.out.println(reviewList);
    }

    public Review removeReview(int index) {
        reviewList.remove(index);
        orderReviewsByScore();
        System.out.println(reviewList);
        return null;

    }

    public void updateReview(Review review) {
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).id.equals(review.id)) {
                reviewList.set(i, review);
                break;
            }
        }
        orderReviewsByScore();
        System.out.println(reviewList);

    }

    public void orderReviewsByScore() {
        if (reviewList.size() > 1) {
            Collections.sort(reviewList);
        } else {
            // too little to sort
        }
    }

    @Override
    public String toString() {
        return "Paper{" +
                "ID='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviewlist=" + reviewList +
                "}\n";
    }
}
