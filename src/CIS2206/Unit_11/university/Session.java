package CIS2206.Unit_11.university;

import java.util.Arrays;

public class Session {
    String sessionID;
    String location;
    Talk[] talkList;
    int size;

    // create the talklist of size 4
    public Session(String sessionID, String location) {
        this.sessionID = sessionID;
        this.location = location;
        this.talkList = new Talk[4];
        size = 0;
    }

    // add the talks
    public void addTalk(Talk talk) {
        //check dupe
        if (hasDuplicateTalk(talk)) {
        }
        else {
            //check not too big
            if (size < talkList.length) {
                talkList[size] = talk;
                size++;
            }
            else {
                //
            }
        }
        sortTalksByTime();
    }

    private boolean hasDuplicateTalk(Talk newTalk) {
        // get talk id from talk
        String newTalkID = newTalk.getTalkID();
        for (int i = 0; i < size; i++) {
            if (talkList[i] != null && talkList[i].getTalkID().equals(newTalkID)) {
                //dupe found
                return true;
            }
        }
        // no dupe
        return false;
    }

    public Talk[] removeTalk(String talkID) {
        // check if talkList is null
        if (talkList == null) {
            // return original talkList if null
            return talkList;
        }

        // search for the index of the talk with the given talkID
        int foundIndex = -1;
        for (int i = 0; i < size; i++) {
            // check if the talk at index i has the same ID as the given talkID
            if (talkList[i] != null && talkList[i].getTalkID().equals(talkID)) {
                foundIndex = i;
                // if found exit
                break;
            }
        }

        // if the talk with the given ID is found
        if (foundIndex != -1) {
            // create a new array to hold talks with one less element
            Talk[] newarray = new Talk[talkList.length - 1];
            for (int i = 0, k = 0; i < size; i++) {
                if (i == foundIndex) {
                    continue;
                }
                newarray[k++] = talkList[i];
            }
            talkList = newarray;
            // subtract 1 from the size as talk is removed
            size--;
        }
        // return new talkList
        sortTalksByTime();
        return talkList;
    }

    public void sortTalksByTime() {
        // sorts the list based on the compareTo() in Talk
        Arrays.sort(talkList, 0, size);
    }

    @Override
    public String toString() {
        Talk[] notNullTalk = Arrays.copyOfRange(talkList, 0, size);
        return "Session{" +
                "ID='" + sessionID + '\'' +
                ", location='" + location + '\'' +
                ", talkList='" + Arrays.toString(notNullTalk) + '\'' +
                ", size=" + size +
                "}\n";
    }
}
