/**
 * EfficientMarkovWord class
 * 
 * @author Ginny Dang
 * @version July 16th, 2022
 */

import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder; // how many words to use in prediction
    private HashMap<WordGram, ArrayList<String>> myMap;
    
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        myMap = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text) {
        myText = text.split("\\s+");
    }
    
    public void buildMap() {
        for (int k = 0; k <= myText.length - myOrder; k++) {
            WordGram key = new WordGram(myText, k, myOrder);
            // The very last character in myText
            if (k == myText.length - myOrder) {
                if (!myMap.containsKey(key)) {
                    myMap.put(key, new ArrayList<String>());
                }
            }
            // The character in between myText
            else {
                String follow = myText[k + myOrder];
                if (myMap.containsKey(key)) {
                    myMap.get(key).add(follow);
                } else {
                    ArrayList<String> follows = new ArrayList<String>();
                    follows.add(follow);
                    myMap.put(key, follows);
                }
            }
        }
    }
    
    // This method is for testing purpose only
    public void printHashMapInfo() {
        ArrayList<WordGram> largestKeys = new ArrayList<WordGram>();
        int largestSize = 0;
        
        System.out.println("HashMap: ");
        for (WordGram key : myMap.keySet()) {
            ArrayList<String> follows = myMap.get(key);
            //System.out.println(key + " : " + follows);
            int currSize = follows.size();
            if (currSize > largestSize) {
                largestSize = currSize;
            }
        }
        
        for (WordGram key : myMap.keySet()) {
            if (myMap.get(key).size() == largestSize) {
                largestKeys.add(key);
            }
        }
        
        System.out.println("Number of keys: " + myMap.size());
        System.out.println("Maximum number of elements following a key: " + largestSize);
        System.out.println("Keys that have the largest ArrayList: " + largestKeys);
        for (WordGram largeKey : largestKeys) {
            System.out.println("(" + largeKey + ")" + " is followed by " + myMap.get(largeKey));
        }
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
        return myMap.get(kGram);
    }
    
    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key);
        sb.append(" ");
        myMap.clear();
        for (int k = 0; k < numWords - myOrder; k++) {
            if (!myMap.containsKey(key)) {
                buildMap();
            }
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