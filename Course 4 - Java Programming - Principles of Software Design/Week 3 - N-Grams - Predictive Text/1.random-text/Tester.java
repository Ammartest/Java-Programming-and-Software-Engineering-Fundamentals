/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class Tester {
    public void testGetFollows() {
        String st = "this is a test yes this is a test.";
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> follows = markov.getFollows("t");
        //ArrayList<String> follows = markov.getFollows("e");
        //ArrayList<String> follows = markov.getFollows("es");
        //ArrayList<String> follows = markov.getFollows(".");
        //ArrayList<String> follows = markov.getFollows("t.");
        for (String follow : follows) {
            System.out.print(follow + ",");
        }
        System.out.println("\n" + follows.size());
    }
    
    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> follows = markov.getFollows("th");
        for (String follow : follows) {
            System.out.print(follow + ",");
        }
        System.out.println("\n" + follows.size());
    }
}