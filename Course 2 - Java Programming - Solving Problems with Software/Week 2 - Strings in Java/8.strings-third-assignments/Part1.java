/**
 * Programming Exercise: Storing All Genes - Part 1
 * 
 * @author Ginny Dang
 * @version July 6th, 2022
 */

import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        
        return dna.length();
    }
    
    public String findGene(String dna, int where) {
        // Find the index of the start codon
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        // Find the index of each possible stop codon
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // Find the index of the closest stop codon
        int minIndex = 0;
        
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        
        if (minIndex == -1 || minIndex + 3 > dna.length()) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    public int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            count += 1;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return count;
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return geneList;
    }
    
    public float cgRatio(String dna) {
        float cgratio = 0;
        int cgcount = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'c' || dna.charAt(i) == 'G' || dna.charAt(i) == 'g') {
                cgcount += 1;
            }
        } 
        cgratio = (float) cgcount / dna.length();
        return cgratio;
    }
    
    public int countCTG(String dna) {
        int count = 0;
        int index = dna.indexOf("CTG");
        while (true) {
            if (index == -1) {
                break;
            } else {
                count = count + 1;
            }
            index = dna.indexOf("CTG", index + 3);
        }
        return count;
    }
    
    public void processGenes(StorageResource sr) {
        int longer = 0; // Number of strings are longer than 60 characters
        int higher = 0; // Number of strings whose C-G-ratio is higher than 0.35
        int longestLength = -1;
        
        for (String gene: sr.data()) {
            if (gene.length() > 60) {
                System.out.println(gene + " is longer than 60 characters");
                longer += 1;
            }
            
            if (cgRatio(gene) > 0.35) {
                System.out.println(gene + " has the C-G-ratio higher than 0.35");
                higher += 1;
            }
            
            if (gene.length() > longestLength) {
                longestLength = gene.length();
            }
        }
        
        System.out.println("Number of Strings that are longer than 60 characters: " + longer);
        System.out.println("Number of strings whose C-G-ratio is higher than 0.35: " + higher);
        System.out.println("The length of the longest gene: " + longestLength);
    }
    
    public void testFindStopCodon() {
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
        String gene = findGene(dna, 0);
        if (!gene.equals("ATGCCCGGGAAATAA")) {
            System.out.println("error");
        }
        System.out.println("test finished");
    }
    
    public void testOn(String dna) {
        System.out.println("Testing getAllGenes on " + dna);
        StorageResource genes = getAllGenes(dna);
        
        for (String gene: genes.data()) {
            System.out.println(gene);
        }
    }
    
    public void test() {
        //      ATGv  TAAv  ATG   v  v  TGA
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        System.out.println("");
        //      ATGv  v  v  v  TAAv  v  v  ATGTAA
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        System.out.println("");
        //testOn("AATGCTAACTAGCTGACTAAT");
    }
    
    public void testCgRatio() {
        String dna = "ATGCCATAG";
        float cgratio = cgRatio(dna);
        System.out.println(cgratio);
    }
    
    public void testProcessGenes() {
        //FileResource fr = new FileResource("brca1line.fa");
        //String dna = fr.asString().toUpperCase();
        
        URLResource ur = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna = ur.asString().toUpperCase();
        
        System.out.println(dna);
        System.out.println("DNA file length :" + dna.length());
      
        StorageResource sr = getAllGenes(dna);
        for (String g : sr.data()){
            System.out.println(g);
        }
        processGenes(sr);
        
        int CTGCount = countCTG(dna);
        int CountG = countGenes(dna);
        System.out.println("CTG count : " + CTGCount);
        System.out.println("Total genes " + CountG);
    }
}








