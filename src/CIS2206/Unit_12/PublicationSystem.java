package CIS2206.Unit_12;

import java.util.LinkedList;

public class PublicationSystem {
    public static void main(String[] args) {

        Paper p1 = new Paper("1","paper1","jeff");
        Paper p2 = new Paper("2","paper2","fred");
        Paper p3 = new Paper("3","paper3","bob");

        Review p1rev1 = new Review("p1rev1","jeremy",7,4,"amazing");
        p1.addReview(p1rev1);
        Review p1rev2 = new Review("p1rev2","james",9,5,"great");
        p1.addReview(p1rev2);
        Review p1rev3 = new Review("p1rev3","richard",8,4,"fantastic");
        p1.addReview(p1rev3);

        Review p2rev1 = new Review("p2rev1","jeremy",2,1,"could be better");
        p2.addReview(p2rev1);
        Review p2rev2 = new Review("p2rev2","james",3,2,"nneds improvement");
        p2.addReview(p2rev2);
        Review p2rev3 = new Review("p2rev3","richard",3,1,"bad");
        p2.addReview(p2rev3);

        Review p3rev1 = new Review("p3rev1","jeremy",5,3,"not bad");
        p3.addReview(p3rev1);
        Review p3rev2 = new Review("p3rev2","james",6,2,"ok");
        p3.addReview(p3rev2);
        Review p3rev3 = new Review("p3rev3","richard",7,4,"can do a little better");
        p3.addReview(p3rev3);

//        System.out.println("//////////////////////");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
//        System.out.println("//////////////////////");

        p1.removeReview(0);

        Review p3rev3update = new Review("p3rev3","richard",4,4,"bad");

        p3.updateReview(p3rev3update);
        System.out.println(p3);
        p3.removeReview(2);
        System.out.println(p3);

        LinkedList<Paper> paperList = new LinkedList<>();
        paperList.add(p1);
        paperList.add(p2);
        paperList.add(p3);

        int topscore = 0;
        for (Paper p : paperList) {
            int weightedAvg = 0;
            int totalConfidence = 0;
            for (Review review : p.reviewList) {
                int score = review.score * review.confidence; // Multiplying score by confidence
                weightedAvg += score;
                totalConfidence += review.confidence; // Accumulating total confidence
            }
            if (totalConfidence != 0) {
                weightedAvg /= totalConfidence; // Calculating the weighted average score
                if (weightedAvg > topscore) {
                    topscore = weightedAvg;
                    System.out.println("Best paper award winner is " + p.title + " with score " + topscore);
                }
            }
        }
    }
}
