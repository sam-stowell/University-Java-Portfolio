package CIS2206.Unit_12;

public class Review implements Comparable<Review> {
    String id;
    String reviewer;
    Integer score;
    Integer confidence;
    String summary;

    public Review(String id, String reviewer, Integer score, Integer confidence, String summary) {
        this.id = id;
        this.reviewer = reviewer;
        this.score = Math.min(Math.max(score, 1), 10);
        this.confidence = Math.min(Math.max(confidence, 1), 5);
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "Review{" +
                "ID='" + id + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", score='" + score + '\'' +
                ", confidence='" + confidence + '\'' +
                ", summary=" + summary +
                "}\n";
    }

    @Override
    public int compareTo(Review r) {
//        return this.score.compareTo(r.score); // ascending order
        return -this.score.compareTo(r.score); // descending order
    }
}
