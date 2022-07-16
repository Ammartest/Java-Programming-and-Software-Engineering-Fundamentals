/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println(markov);
        for(int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 88;
        
        IMarkovModel mZero = new MarkovZero();
        runModel(mZero, st, size, seed);
        
        IMarkovModel mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        IMarkovModel mFour = new MarkovFour();
        runModel(mFour, st, size, seed);
        
        IMarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k = 0; k < words.length; k++){
            System.out.print(words[k] + " ");
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
        /*
        int n = 2;
        int seed = 42;
        int size = 50;
        */
        int n = 5;
        //int n = 6;
        //int seed = 615;
        //int seed = 792;
        int seed = 531;
        //int size = st.length();
        int size = 200;
        
        EfficientMarkovModel markov = new EfficientMarkovModel(n);
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
        int size = 1000;
        
        MarkovModel markov = new MarkovModel(n);
        runModel(markov, st, size, seed);
        System.out.println("Markov Model execution time: " + System.nanoTime() + "\n\n");
        
        EfficientMarkovModel effMarkov = new EfficientMarkovModel(n);
        runModel(effMarkov, st, size, seed);
        System.out.println("Efficient Markov Model execution time: " + System.nanoTime() + "\n\n");
    }
}