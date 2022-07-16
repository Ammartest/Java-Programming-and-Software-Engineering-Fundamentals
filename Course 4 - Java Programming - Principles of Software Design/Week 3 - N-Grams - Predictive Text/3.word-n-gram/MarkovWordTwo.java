/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author Ginny Dang
 * @version July 15th, 2022
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text) {
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - 2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index + 1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for (int k = 0; k < numWords - 2; k++) {
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            //System.out.println(key1 + " " + key2 + " : " + follows);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target1, String target2, int start) {
        for (int k = start; k < words.length - 1; k++) {
            if (words[k].equals(target1) && words[k + 1].equals(target2)) {
                return k;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length) {
            int start = indexOf(myText, key1, key2, pos);
            if (start == -1) {
                break;
            }
            if (start + 2 >= myText.length - 1) {
                break;
            }
            //String next = Character.toString(myText.charAt(index + 1));
            String next = myText[start + 2];
            follows.add(next);
            pos = start + 1;
        }
        return follows;
    }
    
    public void testIndexOf() {
        String[] words = {"this", "is", "just", "a", "test", "yes", "this", "is", "a", "simple", "test"};
        System.out.println(indexOf(words, "this", "is", 0));
        System.out.println(indexOf(words, "this", "just", 3));
        System.out.println(indexOf(words, "frog", "test", 0));
        System.out.println(indexOf(words, "frog", "a", 5));
        System.out.println(indexOf(words, "simple", "test", 2));
        System.out.println(indexOf(words, "test", "yes", 5));
    }
}