/**
 * Coding While Loop
 * 
 * @author Ginny Dang 
 * @version July 5th, 2022
 */
public class FindGeneWhile {
    public String findGene(String dna) {
        // Find first occurrence of "ATG", call its index "startIndex"
        int startIndex = dna.indexOf("ATG");
        // Find the "TAA" starting from (startIndex + 3), call it currIndex
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        // As long as currIndex is not equal to -1,
        while (currIndex != -1) {
            // Check if (currIndex - startIndex) is a multiple of 3
            if ((currIndex - startIndex) % 3 == 0) {
                // If so, the text between startIndex and currIndex
                return dna.substring(startIndex, currIndex + 3);
            } 
            // If not, update currIndex to the index
            else {
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        // Your answer is the empty string
        return "";
    }
    
    public void testFindGene() {
        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CGATGGTTGATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CGATGGTTGATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
    }
}
