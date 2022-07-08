/**
 * Transform words from a file into another form, such as replacing vowels with an asterix. 
 * 
 * @author Ginny Dang
 * @version (a version number or a date)
 */

public class WordPlay {
    public boolean isVowel(char ch) {
        boolean isVowel = false;
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                isVowel = true;
            }
        return isVowel;
    }
    
    public void testIsVowel() {
        boolean isVowel = isVowel('F');
        System.out.println(isVowel);
        isVowel = isVowel('a');
        System.out.println(isVowel);
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < newPhrase.length(); i++) {
            char currChar = newPhrase.charAt(i);
            if (isVowel(currChar)) {
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }
    
    public void testReplaceVowels() {
        String aStr = replaceVowels("Hello World", '*');
        System.out.println(aStr);
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < newPhrase.length(); i++) {
            char currChar = newPhrase.charAt(i);
            if (currChar == Character.toUpperCase(ch) || currChar == Character.toLowerCase(ch)) {
                if (i % 2 == 0) {
                    newPhrase.setCharAt(i, '*');
                } else {
                    newPhrase.setCharAt(i, '+');
                }
            }
        }
        return newPhrase.toString();
    }
    
    public void testEmphasize() {
        String aStr = emphasize("dna ctgaaactga", 'a');
        System.out.println(aStr);
        aStr = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(aStr);
    }
}
