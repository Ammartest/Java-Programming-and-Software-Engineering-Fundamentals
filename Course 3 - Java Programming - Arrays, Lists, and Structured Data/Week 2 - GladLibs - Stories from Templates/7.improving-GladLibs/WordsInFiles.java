/**
 * Determine which words occur in the greatest number of files, and for each word, which files they occur in
 * 
 * @author Ginny Dang
 * @version July 10th, 2022
 */

import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    
    public WordsInFiles() {
        map = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        String fn = f.getName();
        for (String word : fr.words()) {
            if (!map.containsKey(word)) {
                ArrayList<String> fs = new ArrayList<String>();
                fs.add(fn);
                map.put(word, fs);
            } else {
                ArrayList<String> fs = map.get(word);
                if (!fs.contains(fn)) {
                    fs.add(fn);
                }
            }
        }
    }
    
    public void buildWordFileMap() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber() {
        int maxNumFiles = 0;
        for (String word : map.keySet()) {
            int numFiles = map.get(word).size();
            if (numFiles > maxNumFiles) {
                maxNumFiles = numFiles;
            }
        }
        return maxNumFiles;
    }
    
    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> listOfWords = new ArrayList<String>();
        for (String word : map.keySet()) {
            int numFiles = map.get(word).size();
            if (numFiles == number) {
                listOfWords.add(word);
            }
        }
        return listOfWords;
    }
    
    public void printFilesIn(String word) {
        ArrayList<String> listOfFiles = map.get(word);
        for (String fileName : listOfFiles) {
            System.out.println(fileName);
        }
    }
    
    public void tester() {
        // Print the result
        buildWordFileMap();
        //int max = maxNumber();
        /*
        System.out.println("The greatest number of files a word appears in is " + max + " and those words are:");
        for (String word : map.keySet()) {
            ArrayList<String> listOfFiles = map.get(word);
            if (listOfFiles.size() == max) {
                System.out.println('"' + word + '"' + " appears in the files: " + listOfFiles.toString().replace("[","").replace("]",""));
            }
        }
        */
        // Print the hashmap
        //System.out.println("\n");
        //for (String word : map.keySet()) {
        //    System.out.println(word + "=" + map.get(word));
        //}
        //System.out.println(wordsInNumFiles(5).size());
        //System.out.println(wordsInNumFiles(4).size());
        //System.out.println(map.get("red"));
        
        //System.out.println(wordsInNumFiles(7).size());
        //System.out.println(wordsInNumFiles(4).size());
        //System.out.println(map.get("laid"));
        //System.out.println(map.get("sea"));
        System.out.println(map.get("tree"));
    }
}