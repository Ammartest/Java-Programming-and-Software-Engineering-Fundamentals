/**
 * Programming Exercise: Finding a Gene and Web Links - Part 2
 * 
 * @author Ginny Dang 
 * @version July 5th, 2022
 */

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Determine the case of the DNA string
        if (dna.equals(dna.toLowerCase())) {
            // The DNA string is in lower case, 
            // then the 2 given codons must be in lower case as well
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        } else {
            // The DNA string is in upper case, 
            // then the 2 given codons must be in upper case as well
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        
        String result = "";
        // Get the start codon
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            // No start codon
            return "";
        }
        // Get the stop codon
        int stopIndex = dna.indexOf(stopCodon, startIndex + startCodon.length());
        if (stopIndex == -1) {
            // No stop codon
            return "";
        }
        // Get the result string an validate it
        result = dna.substring(startIndex, stopIndex + stopCodon.length());
        if (result.length() % 3 == 0) {
            return result;
        }
        return "";
    }
    
    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "aatgcgtaatatggt";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "aatgctagggtaatatggt";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "atcctatgcttcggctgctctaatatggt";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "TAATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "atgtaa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
    }
    
    public static void main (String[] args) {
        Part2 fg = new Part2();
        fg.testFindGeneSimple();
    }
}
