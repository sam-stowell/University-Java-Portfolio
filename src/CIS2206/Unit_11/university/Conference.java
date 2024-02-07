package CIS2206.Unit_11.university;

public class Conference {
    public static void main(String[] args) {

        Session session1 = new Session("s1","england");

        Talk talk1 = new Talk("1","jeff","talk1","2020-07-10 15:00:00.000");
        session1.addTalk(talk1);
        Talk dupetalkcheck = new Talk("1","jeff","talk1","2020-07-10 15:00:00.000");
        session1.addTalk(dupetalkcheck);
        System.out.println(session1);

        Talk talk2 = new Talk("2","dave","talk2","2020-07-11 15:00:00.000");
        session1.addTalk(talk2);
        System.out.println(session1);

        Talk talk3 = new Talk("3","fred","talk3","2020-04-01 14:00:00.000");
        session1.addTalk(talk3);
        System.out.println(session1);

        Talk talk4 = new Talk("4","bob","talk4","2020-06-09 14:00:00.000");
        session1.addTalk(talk4);
        System.out.println(session1);

        session1.removeTalk("3");
        session1.removeTalk("4");
        session1.removeTalk("1");
        session1.removeTalk("2");
        System.out.println(session1);


        Session session2 = new Session("s2","england");

        Talk talk6 = new Talk("1","jeff","talk1","2020-07-10 15:00:00.000");
        session2.addTalk(talk6);
        System.out.println(session2);

        Session session3 = new Session("s3","england");

        Talk talk7 = new Talk("1","jeff","talk1","2020-07-10 15:00:00.000");
        session3.addTalk(talk7);
        System.out.println(session3);

        Session session4 = new Session("s4","england");

        Talk talk8 = new Talk("1","jeff","talk1","2020-07-10 15:00:00.000");
        session4.addTalk(talk8);
        System.out.println(session4);

    }

}
