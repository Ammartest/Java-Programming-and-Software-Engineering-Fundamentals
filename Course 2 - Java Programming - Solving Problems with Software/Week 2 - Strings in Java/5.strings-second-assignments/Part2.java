/**
 * Programming Exercise: Finding Many Genes - Part 2
 * 
 * @author Ginny Dang 
 * @version July 6th, 2022
 */

public class Part2 {
    public int howMany(String stringa, String stringb) {
        int appearances = 0;
        int startA = 0;
        while (true) {
            if (startA == 0) {
                startA = stringb.indexOf(stringa, startA);
            } else {
                startA = stringb.indexOf(stringa, startA + stringa.length());
            }
            
            if (startA == -1) {
                break;
            } else {
                appearances += 1;
            }
        }
        return appearances;
    }
    
    public void testHowMany() {
        int appearances = howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println(appearances);
        
        appearances = howMany("AA", "ATAAAA");
        System.out.println(appearances);
    }
}
