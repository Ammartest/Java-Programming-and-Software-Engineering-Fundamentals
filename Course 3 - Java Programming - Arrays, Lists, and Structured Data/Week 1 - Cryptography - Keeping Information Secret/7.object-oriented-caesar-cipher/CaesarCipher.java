/**
 * Object Oriented Caesar Cipher
 * 
 * @author Ginny Dang
 * @version July 9th, 2022
 */

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            boolean lower = Character.isLowerCase(c);
            int idx = -1;
            // Determine the index of the new character in shiftedAlphabet
            if (lower == true) {
                idx = alphabet.indexOf(Character.toUpperCase(c));
            } else {
                idx = alphabet.indexOf(c);
            }
            // Determine the new character
            if (idx != -1) {
                if (lower == true) {
                    c = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                } else {
                    c = shiftedAlphabet.charAt(idx);
                }
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}