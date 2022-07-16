/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Ginny Dang
 * @version July 16th, 2022
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k = 0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkovWord() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //int order = 3;
        int order = 5;
        int size = 200;
        //int seed = 643;
        //int seed = 621;
        int seed = 844;
        MarkovWord markovWord = new MarkovWord(order);
        runModel(markovWord, st, size, seed);
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k = 0; k < words.length; k++){
            System.out.print(words[k] +  " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
    public void testHashMap() {
        //String st = "yes-this-is-a-thin-pretty-pink-thistle";
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //st = "this is a test yes this is really a test";
        //st = "this is a test yes this is really a test yes a test this is wow";
        int order = 2;
        //int order = 3;
        //int seed = 42;
        //int seed = 371;
        int seed = 65;
        //int size = 50;
        
        EfficientMarkovWord markov = new EfficientMarkovWord(order);
        markov.setTraining(st);
        markov.setRandom(seed);
        markov.buildMap();
        markov.printHashMapInfo();
        //runModel(markov, st, size, seed);
    }
    
    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int n = 2;
        int seed = 42;
        int size = 100;
        
        MarkovWord markov = new MarkovWord(n);
        runModel(markov, st, size, seed);
        System.out.println("Markov Word execution time: " + System.nanoTime() + "\n\n");
        
        EfficientMarkovWord effMarkov = new EfficientMarkovWord(n);
        runModel(effMarkov, st, size, seed);
        System.out.println("Efficient Markov Word execution time: " + System.nanoTime() + "\n\n");
    }
}