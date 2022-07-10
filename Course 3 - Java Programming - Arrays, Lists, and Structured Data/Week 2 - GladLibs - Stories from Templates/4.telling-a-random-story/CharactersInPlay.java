/**
 * Determine the characters in the Shakespeare’s play named "The Tragedy of Macbeth"
 * 
 * @author Ginny Dang
 * @version July 9th, 2022
 */

import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay() {
        characterNames = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        person = person.trim();
        if (!characterNames.contains(person)) {
            characterNames.add(person);
            counts.add(1);
        } else {
            int index = characterNames.indexOf(person);
            int count = counts.get(index);
            counts.set(index, count + 1);
        }
    }
    
    public void findAllCharacters() {
        characterNames.clear();
        counts.clear();
        FileResource resource = new FileResource();
        for (String line : resource.lines()) {
            //System.out.println(line);
            int firstDotPos = line.indexOf('.');
            if (firstDotPos != -1 && Character.isUpperCase(line.charAt(firstDotPos - 1))) {
                String name = line.substring(0, firstDotPos);
                if (!name.contains("ACT") && !name.contains("SCENE")) {
                    update(name);
                }
            }
        }
    }
    
    public String findMainCharacters() {
        int max = counts.get(0);
        String main = characterNames.get(0);
        for (int k = 0; k < characterNames.size(); k++) {
            if (counts.get(k) > max) {
                max = counts.get(k);
                main = characterNames.get(k);
            }
        }
        return main;
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        // Assume num1 should be less than or equal to num2
        for (int i = 0; i < characterNames.size(); i++) {
            if (counts.get(i) >= num1 && counts.get(i) <= num2) {
                System.out.println(characterNames.get(i));
            }
        }
    }
    
    public void tester() {
        findAllCharacters();
        //System.out.println("All characters in this play:");
        //for (int k = 0; k < characterNames.size(); k++) {
        //    System.out.println(characterNames.get(k) + "\t" + counts.get(k));
        //}
        String mainCharacter = findMainCharacters();
        //System.out.println("The character with the most speaking parts: " + mainCharacter);
        charactersWithNumParts(10,15);
    }
}