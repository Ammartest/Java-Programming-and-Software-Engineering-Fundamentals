/**
 * Write a description of MarkovModel here.
 * 
 * @author Ginny Dang
 * @version July 15th, 2022
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int N;
    private HashMap<String, ArrayList<String>> myMap;
    
    public EfficientMarkovModel(int n) {
        myRandom = new Random();
        N = n;
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public void buildMap() {
        for (int k = 0; k <= myText.length() - N; k++) {
            String key = myText.substring(k, k + N);
            // The very last character in the text
            if (k == myText.length() - N) {
                if (!myMap.containsKey(key)) {
                    myMap.put(key, new ArrayList<String>());
                }
            }
            // The character in between the text
            else {
                String follow = myText.substring(k + N, k + N + 1);
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
        ArrayList<String> largestKeys = new ArrayList<String>();
        int largestSize = 0;
        
        for (String key : myMap.keySet()) {
            ArrayList<String> follows = myMap.get(key);
            //System.out.println(key + " : " + follows);
            int currSize = follows.size();
            if (currSize > largestSize) {
                largestSize = currSize;
            }
        }
        
        for (String key : myMap.keySet()) {
            if (myMap.get(key).size() == largestSize) {
                largestKeys.add(key);
            }
        }
        
        System.out.println("HashMap: ");
        System.out.println("Size: " + myMap.size());
        System.out.println("Maximum number of keys following a key: " + largestSize);
        System.out.println("Keys that have the largest ArrayList: " + largestKeys);
    }
    
    public ArrayList<String> getFollows(String key) {
        return myMap.get(key);
    }
    
    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - N);
        String key = myText.substring(index, index + N);
        sb.append(key);
        myMap.clear();
        for (int k = 0; k < numChars - N; k++) {
            if (!myMap.containsKey(key)) {
                buildMap();
            }
            ArrayList<String> follows = getFollows(key);
            /*
            if (follows == null) {
                break;
            }
            */
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }
    
    public String toString() {
       return String.format("EfficientMarkovModel of order " + N);
    }
}