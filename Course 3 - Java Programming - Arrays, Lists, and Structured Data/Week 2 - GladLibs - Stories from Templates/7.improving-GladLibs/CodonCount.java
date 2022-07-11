/**
 * Count how many times each codon occurs in a strand of DNA based on reading frames
 * 
 * @author Ginny Dang
 * @version July 10th, 2022
 */

/**
 * CGTTCAAGTTCAA
 * 0: CGT, TCA, AGT, TCA
 * 1: GTT, CAA, GTT, CAA
 * 2: TTC, AAG, TTC
 * 
 * map = {CGT: 1,
 *        TCA: 2,
 *        AGT: 1,
 *        GTT: 2,
 *        CAA: 2,
 *        TTC: 2,
 *        AAG: 1}
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> codonCounts;
    
    public CodonCount() {
         codonCounts = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna) {
        /* CGTTCAAGTTCAA
         * 0123456789012
         * i = 1  -> i + 3 = 4  -> dna.substring(1, 4)   = GTT
         * i = 4  -> i + 3 = 7  -> dna.substring(4, 7)   = CAA
         * i = 7  -> i + 3 = 10 -> dna.substring(7, 10)  = GTT
         * i = 10 -> i + 3 = 13 -> dna.substring(10, 13) = CAA
         */
        if (codonCounts.size() != 0) {
            codonCounts.clear();
        }
        for (int i = start; i < dna.length(); i += 3) {
            if (i + 3 <= dna.length()) {
                String curCodon = dna.substring(i, i + 3);
                if (!codonCounts.containsKey(curCodon)) {
                    codonCounts.put(curCodon, 1);
                } else {
                    codonCounts.put(curCodon, codonCounts.get(curCodon) + 1);
                }
            }
        }
    }
    
    public String getMostCommonCodon() {
        String mostCommon = "";
        int maxCount = 0;
        for (String codon : codonCounts.keySet()) {
            int currCount = codonCounts.get(codon);
            if (currCount > maxCount) {
                maxCount = currCount;
                mostCommon = codon;
            }
        }
        return mostCommon;
    }
    
    public void printCodonCounts(int start, int end) {
        for (String codon : codonCounts.keySet()) {
            int count = codonCounts.get(codon);
            if (count >= start && count <= end) {
                System.out.println(codon + " " + count);
            }
        }
    }
    
    public void tester() {
        // Read the DNA from file
        FileResource fr = new FileResource();
        String dna = fr.asString().trim().toUpperCase();
        // Pass in a DNA as a string
        //String dna = "CGTTCAAGTTCAA";
        int start = 7;
        int end = 7;
        for (int frameStart = 0; frameStart < 3; frameStart++) {
            buildCodonMap(frameStart, dna);
            String most = getMostCommonCodon();
            System.out.println("Reading frame starting with " + frameStart + " results in " + codonCounts.size() + " unique codons");
            System.out.println(" and most common codon is " + most + " with count " + codonCounts.get(most));
            System.out.println("Counts of codons between " + start + " and " + end + " inclusive are:");
            printCodonCounts(start, end);
            System.out.println("\n");
        }
    }
}