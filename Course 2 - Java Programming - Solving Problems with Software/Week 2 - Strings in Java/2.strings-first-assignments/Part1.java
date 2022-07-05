/**
 * Programming Exercise: Finding a Gene and Web Links - Part 1
 * 
 * @author Ginny Dang 
 * @version July 5th, 2022
 */

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        // Get the start codon, which is "ATG"
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            // No ATG
            return "";
        }
        // Get the stop codon, which is "TAA"
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            // No TAA
            return "";
        }
        // Get the result string an validate it
        result = dna.substring(startIndex, stopIndex + 3);
        if (result.length() % 3 == 0) {
            return result;
        }
        return "";
    }
    
    public void testFindGeneSimple() {
        /*String dna = "AATGCGTAATATGGT";
        //System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        // dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        // dna = "ATGTAA";
        dna = "TAATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);*/
        
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
    
    public static void main (String[] args) {
        Part1 fg = new Part1();
        fg.testFindGeneSimple();
    }
}
