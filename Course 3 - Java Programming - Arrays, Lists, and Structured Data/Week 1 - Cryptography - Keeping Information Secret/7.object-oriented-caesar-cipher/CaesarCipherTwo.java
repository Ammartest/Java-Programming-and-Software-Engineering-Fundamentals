/**
 * Object Oriented Caesar Cipher with 2 keys
 * 
 * @author Ginny Dang
 * @version July 9th, 2022
 */

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            boolean lower = Character.isLowerCase(currChar);
            int idx = -1;
            // Determine the index of the new character in shiftedAlphabet
            if (lower == true) {
                idx = alphabet.indexOf(Character.toUpperCase(currChar));
            } else {
                idx = alphabet.indexOf(currChar);
            } 
            // Determine the new character
            if (i % 2 == 0) {
                if (idx != -1) {
                    if (lower == true) {
                        currChar = Character.toLowerCase(shiftedAlphabet1.charAt(idx));
                    } else {
                        currChar = shiftedAlphabet1.charAt(idx);
                    }
                }
            } else {
                if (idx != -1) {
                    if (lower == true) {
                        currChar = Character.toLowerCase(shiftedAlphabet2.charAt(idx));
                    } else {
                        currChar = shiftedAlphabet2.charAt(idx);
                    }
                }
            }
            // Set the new char to the new encrypted string
            encrypted.setCharAt(i, currChar);
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        String decrypted = cc2.encrypt(input);
        return decrypted;
    }
}
