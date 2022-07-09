/**
 * Test the Object Oriented Caesar Cipher
 * 
 * @author Ginny Dang
 * @version July 9th, 2022
 */

import edu.duke.*;

public class TestCaesarCipher {
    private int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    private int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public String breakCaesarCipher(String input) {
        // Find the encrypt key
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if (maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        System.out.println(key);
        // Decrypt the input
        CaesarCipher cc = new CaesarCipher(key);
        String decrypted = cc.decrypt(input);
        return decrypted;
    }
    
    public void simpleTests() {
        // Read in a file as a string
        //FileResource fr = new FileResource();
        //String message = "";
        //for (String word : fr.words()) {
        //    message += word + " ";
        //}
        
        // Test the CaesarCipher class
        //CaesarCipher cc = new CaesarCipher(18);
        //String encrypted = cc.encrypt(message);
        //System.out.println(encrypted);
        //String decrypted = cc.decrypt(encrypted);
        //System.out.println(decrypted);
        
        // Test the breakCaesarCipher method
        //String broken = breakCaesarCipher(message);
        //System.out.println(broken);
        
        /* Run only one of these above tests each time */
        
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
    }
}