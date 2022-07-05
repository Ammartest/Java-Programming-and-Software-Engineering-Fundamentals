
/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna) {
        // Start codon is "ATG"
        // Stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            // No ATG
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            // No TAA
            return "";
        }
        result = dna.substring(startIndex, stopIndex + 3);
        
        return result;
    }
    
    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        // dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        // dna = "ATGTAA";
        dna = "TAATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }
    
    public static void main (String[] args) {
        FindGeneSimpleAndTest fg = new FindGeneSimpleAndTest();
        fg.testFindGeneSimple();
    }
}
