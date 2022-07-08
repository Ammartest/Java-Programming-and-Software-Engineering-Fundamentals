/**
 * Caesar Cipher Implementation
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        for(int i = 0; i < encrypted.length(); i++) {
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
            if(idx != -1) {
                char newChar = '\0';
                if (lower == true) {
                    newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                } else {
                    newChar = shiftedAlphabet.charAt(idx);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            char newChar = '\0';
            // Determine the new char
            if (i % 2 == 0) {
                newChar = encrypt(Character.toString(currChar), key1).charAt(0);
            } else {
                newChar = encrypt(Character.toString(currChar), key2).charAt(0);
            }
            // Set the new char to the new encrypted string
            encrypted.setCharAt(i, newChar);
        }
        return encrypted.toString();
    }
    
    public void testCaesar() {
        String encryptedString = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println(encryptedString);
        
        //int key = 23;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encrypt(message, key);
        //System.out.println("key is " + key + "\n" + encrypted);
        
        //String encryptedString = encrypt("First Legion", 23);
        //System.out.println(encryptedString);
        //encryptedString = encrypt("First Legion", 17);
        //System.out.println(encryptedString);
        
        encryptedString = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        System.out.println(encryptedString);
    }
}