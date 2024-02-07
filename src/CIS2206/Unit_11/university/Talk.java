package CIS2206.Unit_11.university;

public class Talk implements Comparable<Talk>{
    String talkID;
    String speaker;
    String title;
    String startTime;

    public Talk(String talkID, String speaker, String title, String startTime) {
        this.talkID = talkID;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "ID='" + talkID + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", time='" + startTime +
                "'}\n";
    }

    @Override
    public int compareTo(Talk t) {
        int time = this.startTime.compareTo(t.startTime);
        return time;
    }

    // get id for session to check if the talk is a duplicate
    public String getTalkID() {
        return talkID;
    }
}
