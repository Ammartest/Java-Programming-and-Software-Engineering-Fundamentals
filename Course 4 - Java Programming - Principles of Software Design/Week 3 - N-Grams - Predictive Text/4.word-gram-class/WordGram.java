/**
 * WordGram class
 * 
 * @author Ginny Dang
 * @version July 16th, 2022
 */

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt " + index);
        }
        return myWords[index];
    }

    public int length() {
        return myWords.length;
    }

    public String toString() {
        String ret = "";
        for (int k = 0; k < myWords.length; k++) {
            ret += myWords[k] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if (this.length() != other.length()) {
            return false;
        }
        for (int k = 0; k < myWords.length; k++) {
            if (!myWords[k].equals(other.wordAt(k))) {
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) {	
        String[] outArray = new String[myWords.length];
        for (int k = 0; k < myWords.length; k++) {
            if (k != myWords.length - 1) {
                outArray[k] = myWords[k + 1];
            } else {
                outArray[k] = word;
            }
        }
        WordGram out = new WordGram(outArray, 0, myWords.length);
        return out;
    }
    
    public int hashCode() {
        WordGram myWordGram = new WordGram(myWords, 0, myWords.length);
        String myString = "";
        for (int k = 0; k < myWordGram.length(); k++) {
            myString += myWordGram.wordAt(k);
        }
        return myString.hashCode();
    }
}