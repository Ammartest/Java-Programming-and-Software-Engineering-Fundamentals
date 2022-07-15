/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import java.util.*;

public class MarkovRunner {
    public void runMarkovZero() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        int seed = 88;
        markov.setRandom(seed);
        markov.setTraining(st);
        System.out.println("Seed=" + seed);
        for(int k = 0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovOne() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //st = "this is a test yes this is a test.";
        MarkovOne markov = new MarkovOne();
        int seed = 273;
        markov.setRandom(seed);
        markov.setTraining(st);
        System.out.println("Seed=" + seed);
        for(int k = 0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovFour() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //st = "this is a test yes this is a test.";
        MarkovFour markov = new MarkovFour();
        int seed = 371;
        markov.setRandom(seed);
        markov.setTraining(st);
        System.out.println("Seed=" + seed);
        for(int k = 0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovModel() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //st = "this is a test yes this is a test.";
        int n = 8;
        MarkovModel markov = new MarkovModel(n);
        int seed = 365;
        markov.setRandom(seed);
        markov.setTraining(st);
        System.out.println("Seed=" + seed + ", N=" + n);
        for(int k = 0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k = 0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
}