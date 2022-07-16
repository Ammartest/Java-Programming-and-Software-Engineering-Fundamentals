/**
 * Interface of Markov Models
 * 
 * @author Ginny Dang
 * @version July 15th, 2022
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);
}