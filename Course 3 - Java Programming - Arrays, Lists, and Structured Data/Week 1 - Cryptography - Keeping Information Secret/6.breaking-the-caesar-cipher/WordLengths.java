/**
 * Figure out the most common word length of words from a file
 * 
 * @author Ginny Dang
 * @version July 8th, 2022
 */

import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int currLength = word.length();
            for (int i = 0; i < currLength; i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    currLength -= 1;
                }
            }
            if (currLength >= counts.length) {
                currLength = counts.length - 1;
            }
            counts[currLength] += 1;
        }
    }
    
    public int indexOfMax(int[] values) {
        int largestEle = -1;
        int largestIndex = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > largestEle) {
                largestEle = values[i];
                largestIndex = i;
            }
        }
        return largestIndex;
    }
    
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        for (int k = 0; k < counts.length; k++) {
            if (counts[k] > 1) {
                System.out.println(Integer.toString(counts[k]) + " words of length " + Integer.toString(k));
            }
        }
        int mostCommonLength = indexOfMax(counts);
        System.out.println("The most common word length is " + Integer.toString(mostCommonLength));
    }
}