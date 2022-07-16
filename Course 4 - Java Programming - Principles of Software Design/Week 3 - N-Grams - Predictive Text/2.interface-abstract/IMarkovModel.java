/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author Ginny Dang
 * @version July 15th, 2022
 */

public interface IMarkovModel {
    public void setRandom(int seed);
    
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
}