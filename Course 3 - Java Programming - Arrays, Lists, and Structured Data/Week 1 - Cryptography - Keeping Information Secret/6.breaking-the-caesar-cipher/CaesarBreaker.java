/**
 * Caesar Cipher Two Keys Decrypt
 * 
 * @author Ginny Dang 
 * @version July 8th, 2022
 */

import edu.duke.*;

public class CaesarBreaker  {
    public int[] countLetters(String message) {
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
    
    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        // Distance from the max index to the index of 'e'
        int dkey = maxDex - 4; // 4 is the index of letter 'e'. In English, in most cases, 'e' is usually the letter with highest frequency.
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public void testDecrypt() {
        String decryptedString = decrypt("Just a test string with lots of eeeeeeeeeeeeeeeees");
        System.out.println(decryptedString);
        decryptedString = decrypt("Kvtu b uftu tusjoh xjui mput pg ffffffffffffffffft");
        System.out.println(decryptedString);
        decryptedString = decrypt("Lwuv c vguv uvtkpi ykvj nqvu qh gggggggggggggggggu");
        System.out.println(decryptedString);
        decryptedString = decrypt("Epno v ozno nomdib rdoc gjon ja zzzzzzzzzzzzzzzzzn");
        System.out.println(decryptedString);
    }
    
    public String halfOfString(String message, int start) {
        String half = "";
        for (int i = start; i < message.length(); i += 2) {
            half += message.charAt(i);
        }
        return half;
    }
    
    public void testHalfOfString() {
        String halfStr = halfOfString("Qbkm Zgis", 0);
        System.out.println(halfStr);
        halfStr = halfOfString("Qbkm Zgis", 1);
        System.out.println(halfStr);
    }
    
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        // Distance from the max index to the index of 'e'
        int key = maxDex - 4; // 4 is the index of letter 'e'. In English, in most cases, 'e' is usually the letter with highest frequency.
        if (maxDex < 4) {
            key = 26 - (4 - maxDex);
        }
        return key;
    }
    
    public String decryptTwoKeys(String encrypted) {
        // Calculate a String of every other character starting with the first character of the encrypted String
        String halfFirst = halfOfString(encrypted, 0);
        // Calculate a String of every other character starting with the second character of the encrypted String
        String halfSecond = halfOfString(encrypted, 1);
        // Calculate the key used to encrypt each half String.
        int key1 = getKey(halfFirst);
        int key2 = getKey(halfSecond);
        System.out.println(key1);
        System.out.println(key2);
        // Calculate and return the decrypted String
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
        return decrypted;
    }
    
    public void testDecryptTwoKeys() {
        //String decrypted = decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        //System.out.println(decrypted);
        
        CaesarCipher cc = new CaesarCipher();
        String msg = cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26 - 2, 26 - 20);
        System.out.println(msg);
        
        /*
        FileResource fr = new FileResource();
        String encrypted = "";
        for (String word : fr.words()) {
            encrypted += word + " ";
        }
        String decrypted = decryptTwoKeys(encrypted);
        System.out.println(decrypted);
        */
    }
}