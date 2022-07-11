/**
 * Maps Version of GladLibs
 * 
 * @author Ginny Dang
 * @version July 10th, 2022
 */

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> usedList;
    private ArrayList<String> usedCategories;
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap() {
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source) {
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] categories = new String[]{"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
        for (String category : categories) {
            ArrayList<String> wordList = readIt(source + "/" + category + ".txt");
            myMap.put(category, wordList);
        }
        usedList = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        if (myMap.containsKey(label)) {
            return randomFrom(myMap.get(label));
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String category = w.substring(first + 1, last);
        if (!usedCategories.contains(category)) {
            usedCategories.add(category);
        }
        String sub = getSubstitute(category);
        while (usedList.contains(sub)) {
            sub = getSubstitute(category);
        }
        usedList.add(sub);
        //System.out.println(usedList);
        //System.out.println(usedCategories);
        return prefix + sub + suffix;
    }
    
    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }
    
    public int totalWordsInMap() {
        int total = 0;
        for (String category : myMap.keySet()) {
            total += myMap.get(category).size();
        }
        return total;
    }
    
    public int totalWordsConsidered() {
        int total = 0;
        for (String category : usedCategories) {
            if (!category.equals("number")) {
                total += myMap.get(category).size();
            }
        }
        return total;
    }
    
    public void makeStory() {
        if (usedList.size() != 0) {
            usedList.clear();
        }
        if (usedCategories.size() != 0) {
            usedCategories.clear();
        }
        
        String story = fromTemplate("data/madtemplate.txt");
        //String story = fromTemplate("data/madtemplate2.txt");
        //String story = fromTemplate("data/madtemplate3.txt");
        printOut(story, 60);
        
        System.out.println("\n\n" + "Total number of words that were replaced: " + usedList.size());
        System.out.println("\n");
        
        int totalWords = totalWordsInMap();
        System.out.println("Total number of words that were possible to pick from: " + totalWords);
        
        int totalConsiderations = totalWordsConsidered();
        System.out.println("Total number of words that were actually considered: " + totalConsiderations);
    }
}