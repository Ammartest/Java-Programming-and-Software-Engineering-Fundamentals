/**
 * Finding three stop codons
 * 
 * @author Ginny Dang
 * @version July 5th, 2022
 */

public class AllCodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        // Find stopCodon starting from (startIndex + 3), currIndex
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        // As long as currIndex is not equal to -1
        while (currIndex  != -1) { 
            int diff = currIndex - startIndex;
            // Check if (currIndex - startIndex) is a multiple of 3
            if (diff % 3 == 0) {
                // If so, currIndex is answer, return it
                return currIndex;
            } else {
                // If not, update currIndex, looking for stopCodon starting from currIndex + 1
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        // If we exit loop, we didn't find stopCodon
        // so return dnaStr.length()
        }
        return dnaStr.length();
    }
    
    public String findGene(String dna) {
        // Find 1st occurrence of "ATG", startIndex
        int startIndex = dna.indexOf("ATG");
        // If startIndex is -1, return ""
        if (startIndex == -1) {
            return "";
        }
        // Use taaIndex to store findStopCodon(dna, startIndex, "TAA")
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        // Use tagIndex to store findStopCodon(dna, startIndex, "TAG")
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        // Use tgaIndex to store findStopCodon(dna, startIndex, "TGA")
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // Store in minIndex the smallest of these three values
        int minIndex = Math.min(Math.min(taaIndex, tagIndex), tgaIndex);
        // If minIndex is dna.length()? nothing found, return ""
        if (minIndex == dna.length()){
            return "";
        }
        // Otherwsie, answer is the text from startIndex to minIndex
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testFindStop() {
        //            01234567890123456789012345 
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("test finished");
    }
    
    public void testFindGene() {
       String dna = "ATGCCCGGGAAATAACCC";
       String gene = findGene(dna);
       if (!gene.equals("ATGCCCGGGAAATAA")) {
           System.out.println("error");
       }
       System.out.println("test finished");
    }
}