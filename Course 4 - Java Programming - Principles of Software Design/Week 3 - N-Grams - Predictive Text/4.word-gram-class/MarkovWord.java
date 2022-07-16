/**
 * MarkovWord class
 * 
 * @author Ginny Dang
 * @version July 16th, 2022
 */

import java.util.*;

public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder; // how many words to use in prediction
    
    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text) {
        myText = text.split("\\s+");
    }
    
    private int indexOf(String[] words, WordGram target, int start) {
        for (int k = start; k < words.length; k++) {
            if (k >= words.length - myOrder) {
                break;
            }
            WordGram currWG = new WordGram(words, k, target.length());
            if (currWG.equals(target)) {
                return k;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length - myOrder) {
            int start = indexOf(myText, kGram, pos);
            if (start == -1) {
                break;
            }
            if (start + kGram.length() >= myText.length - myOrder) {
                break;
            }
            String next = myText[start + myOrder];
            follows.add(next);
            pos = start + myOrder;
        }
        return follows;
    }
    
    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key);
        sb.append(" ");
        for (int k = 0; k < numWords - myOrder; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            //System.out.println(key + " : " + follows);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }
    
    public String toString() {
       return String.format("Markov Word Gram of order " + myOrder);
    }
}