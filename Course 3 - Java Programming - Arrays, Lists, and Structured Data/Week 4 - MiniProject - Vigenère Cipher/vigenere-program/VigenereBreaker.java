import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            slice.append(message.charAt(i));
        }
        //System.out.println(allSliceChars);
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker caesarCracker = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String slice = sliceString(encrypted, i, klength);
            key[i] = caesarCracker.getKey(slice);
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        int[] key = tryKeyLength(encrypted, 4, 'e');
        VigenereCipher vigenereCipher = new VigenereCipher(key);
        String decrypted = vigenereCipher.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    
    
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
        char mostCommon = '\u0000';
        int mostFreq = 0;
        HashMap<Character, Integer> charFreqs = new HashMap<Character, Integer>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!charFreqs.containsKey(letter)) {
                    charFreqs.put(letter, 1);
                } else {
                    charFreqs.put(letter, charFreqs.get(letter) + 1);
                }
            }
        }
        for (char currLetter : charFreqs.keySet()) {
            int currFreq = charFreqs.get(currLetter);
            if (currFreq > mostFreq) {
                mostFreq = currFreq;
                mostCommon = currLetter;
            }
        }
        return mostCommon;
    }
}
