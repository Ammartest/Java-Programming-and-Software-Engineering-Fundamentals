/**
 * Programming Exercise: Finding a Gene and Web Links - Part 3
 * 
 * @author Ginny Dang 
 * @version July 5th, 2022
 */

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        int secondIndex = stringb.indexOf(stringa, firstIndex + 1);
        
        if ((firstIndex == -1) || (secondIndex == -1)) {
            return false;
        }
        
        return true;
    }
    
    public String lastPart(String stringa, String stringb) {
        int stringaStart = stringb.indexOf(stringa);
        
        if (stringaStart == -1) {
            return stringb;
        } else {
            String stringbLastPart = stringb.substring(stringaStart + stringa.length());
            return stringbLastPart;
        }
    }
    
    public void testing() {
        // Test the twoOccurrences() method
        boolean occursTwice = twoOccurrences("by", "A story by Abby Long");
        System.out.println(occursTwice);
        
        occursTwice = twoOccurrences("a", "banana");
        System.out.println(occursTwice);
        
        occursTwice = twoOccurrences("atg", "ctgtatgta");
        System.out.println(occursTwice);
        
        // Test the lastPart() method
        String lastpart = lastPart("an", "banana");
        System.out.println(lastpart);
        
        lastpart = lastPart("zoo", "forest");
        System.out.println(lastpart);
    }
    
    public static void main (String[] args) {
        Part3 part3 = new Part3();
        part3.testing();
    }
}
