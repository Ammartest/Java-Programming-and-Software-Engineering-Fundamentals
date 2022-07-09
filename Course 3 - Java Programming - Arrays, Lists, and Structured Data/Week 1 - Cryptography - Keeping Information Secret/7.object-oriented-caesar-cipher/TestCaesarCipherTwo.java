/**
 * Test the Object Oriented Caesar Cipher with 2 keys
 * 
 * @author Ginny Dang
 * @version July 9th, 2022
 */

import edu.duke.*;

public class TestCaesarCipherTwo {
    private String halfOfString(String message, int start) {
        String half = "";
        for (int i = start; i < message.length(); i += 2) {
            half += message.charAt(i);
        }
        return half;
    }
    
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
    
    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        // Distance from the max index to the index of 'e'
        int key = maxDex - 4; // 4 is the index of letter 'e'. In English, in most cases, 'e' is usually the letter with highest frequency.
        if (maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        return key;
    }
    
    public String breakCaesarCipher(String input) {
        // Find the encrypt keys
        String halfFirst = halfOfString(input, 0);
        String halfSecond = halfOfString(input, 1);
        int key1 = getKey(halfFirst);
        int key2 = getKey(halfSecond);
        System.out.println(key1);
        System.out.println(key2);
        // Decrypt the input
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - key1, 26 - key2);
        String decrypted = cc2.encrypt(input);
        return decrypted;
    }
    
    public void simpleTests() {
        // Read in a file as a string
        FileResource fr = new FileResource();
        String message = "";
        for (String word : fr.words()) {
            message += word + " ";
        }
        //System.out.println(message);
        
        // Test the CaesarCipherTwo class
        //CaesarCipherTwo cc2 = new CaesarCipherTwo(17,3);
        //String encrypted = cc2.encrypt(message);
        //System.out.println(encrypted);
        //String decrypted = cc2.decrypt(encrypted);
        //System.out.println(decrypted);
        
        
        // Test the breakCaesarCipher method
        //String broken = breakCaesarCipher(message);
        //System.out.println(broken);
        
        /* Run only one of these above tests each time */
        
        //String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        //CaesarCipherTwo cc2 = new CaesarCipherTwo(21,8);
        //String encrypted = cc2.encrypt(message);
        //System.out.println(encrypted);
        //String decrypted = cc2.decrypt(encrypted);
        //System.out.println(decrypted);
        
        //String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        //CaesarCipherTwo cc2 = new CaesarCipherTwo(14, 24);
        //String decrypted = cc2.decrypt(message);
        //System.out.println(decrypted);
        
        //String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String broken = breakCaesarCipher(message);
        System.out.println(broken);
    }
}