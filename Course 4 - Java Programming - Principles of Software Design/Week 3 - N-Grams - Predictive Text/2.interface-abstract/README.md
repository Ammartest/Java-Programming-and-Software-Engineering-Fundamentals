# Programming Exercise: Interface and Abstract Class

Resource Link:  http://www.dukelearntoprogram.com/course4/index.php 

In this task you will add in a common interface. You will need to keep a copy of your previous program, so that you will have the old version for the quizzes. The new version will organize the program in a different way, using an interface and an abstract class. You will also use a different class in place of the __MarkovRunner__ class to run the program in a different way to take advantage of the new structure.

For this assignment we will give you an incomplete program with some new files. You should look at each of these and understand their parts. They are:

The __IMarkovModel__ interface. It has two signatures: the void method __setTraining__ that has one String parameter named __text__, and the method __getRandomText__ that has one int parameter named __numChars__ and returns a String. 

The class __MarkovRunnerWithInterface__ for running your program to generate random text. This class has several methods:
- A void method named __runModel__ that has three parameters: an __IMarkovModel__ variable named __markov__, a String named __text__ and an int named __size__. This method will work with any markov object that implements __IMarkovModel__.
- A void method named __runMarkov__. This method creates one of the types of Markov models, and calls __runModel__ with it to generate random text.
- A void method named __printOut__ that formats and prints the randomly generated text.

The abstract class __AbstractMarkovModel__ that implements __IMarkovModel__. This class has several items:
- Two protected fields __myText__, a String, and __myRandom__, of type Random.
- A constructor that creates __myRandom__.
- A __setTraining__ method that is public. This method sets the the private String variable __myText__ to the parameter __text__.
- A signature for the abstract method __getRandomText__ that has one integer parameter named __numChars__ indicating the length of the randomly generated text. 

## Assignment 1: IMarkovModel Interface
Specifically, for this assignment, you will:
- Copy over four of the __.java__ files from the the work you did with the previous assignment. (You will need to keep a copy of the program you created from the first two assignments for testing.) Specifically you should copy over the four Java files: __MarkovZero.java__, __MarkovOne.java__, __MarkovFour.java__, and __MarkovModel.java__. You can ignore the following files from the previous lesson — __MarkovRunner.java__ and __Tester.java__. We will modify the program to organize it in a different way, using an interface and an abstract class.
- Modify your classes __MarkovZero__, __MarkovOne__, __MarkovFour__, and __MarkovModel__ to implement the __IMarkovModel__ interface. Each of these classes should already have the two required methods __setTraining__ and __getRandomText__, so the only change needed is the first line to add 

implements __IMarkovModel__
- Run the method __runMarkov__ that is in the __MarkovRunnerWithInterface__ class. This method should run several Markov objects and generate random text for a __MarkovZero__, a __MarkovOne__, a __MarkovModel__ with number 3, and a __MarkovFour.__ Notice that runMarkov is called with each one of these. You can observe that the text gets more like the training text as you move from MarkovZero to MarkovFour. 

## Assignment 2: AbstractMarkovModel Abstract Class
Now we will integrate the __AbstractMarkovModel__ abstract class — you will need to make several changes, specifically:
- The method __getFollows__ you wrote is the same everywhere. You should move it into the __AbstractMarkovModel__ class and change this method from public to protected. 
- Anything that is protected in __AbstractMarkovModel__ should be deleted in the other files they are in. In each of __MarkovZero__, __MarkovOne__, __MarkovFour__ and __MarkovModel__, delete the declarations of the two private variables __myText__ and __myRandom__, and delete the __getFollows__ method if it has one. 
- Each of __MarkovZero__, __MarkovOne__, __MarkovFour__, and __MarkovModel__ need to change in their definition `implements IMarkovModel` to `extends AbstractMarkovModel`
- Run the method __runMarkov__ that is in the __MarkovRunnerWithInterface__ class. It should run as before. 
- Notice that when you print any markov object, you get its name and an address location. These objects don’t know how to print themselves. Write a __toString__ method, so each one prints out `MarkovModel of order n,` where __n__ is the number. For example, a MarkovFour object should print out “MarkovModel of order 4.”
- Modify your program so that you can set a seed in the __runMarkov__ method in the __MarkovRunnerWithInterface__ class and pass it to the __runModel__ method (add a 4th parameter named seed) to set the random seed for any markov object. In the runModel class you should be able to set this seed with the line:
  ```
  markov.setRandom(seed).
  ```          
- If you try this you get a compile error. What changes in other files will you need to make to get this to work? 

## Assignment 3: HashMap for Efficiency
It was noted that the __getRandomText__ method is inefficient. Suppose it sees the String “he” 50 times. Each time, it will calculate the follow set again, which could take a long time, each time if the training text is long. 

Specifically, you should:

Write a new class named __EfficientMarkovModel__ (make a copy of __MarkovModel__ to start with) that extends __AbstractMarkovModel__ and that builds a HashMap to calculate the follows ArrayList for each possible substring only once, and then uses the HashMap to look at the list of characters following when it is needed. This class should include:
- a __toString__ method to print that this is the __EfficientMarkovModel__ class of a specific number
- a method named __buildMap__ to build the HashMap (Be sure to handle the case where there may not be a follow character. If that key is not in the HashMap yet, then it should be put in mapped to an empty ArrayList.) Think carefully about where to call this method, considering that you will want to build a map for each new training text.
- a __getFollows__ method, but this __getFollows__ method should be much shorter, as it can look up the ArrayList of Strings, instead of computing it each time.

To test your HashMap to make sure it is built correctly, write the void method __printHashMapInfo__ in the __EfficientMarkovModel__ class. Make sure to call this method immediately after building the map. This method should print out the following information about the HashMap:
- Print the HashMap (all the keys and their corresponding values). Only do this if the HashMap is small.
- Print the number of keys in the HashMap
- Print the size of the largest value in the HashMap — that is, the size of the largest ArrayList of characters
- Print the keys that have the maximum size value.

Write a new method named __testHashMap__ in the __MarkovRunnerWithInterface__ class. This method should create an order-2 EfficientMarkovModel with
- seed 42
- the training text is `yes-this-is-a-thin-pretty-pink-thistle`
- the size of the text generated is 50
- Note that `le` occurs only once at the end of the training text

In the __MarkovRunnerWithInterface__ class, call __testHashMap__. You should see that the HashMap has the following information:
- It has 25 keys in the HashMap
- The maximum number of keys following a key is 3
- Keys that have the largest ArrayList (of size 3 in this case) are: `hi`, `s-`, `-t`, `is`, and `th`
- After running it, you’ll probably want to comment out the call to __printHashMapInfo__ in the __EfficientMarkovModel__ class.

In the __MarkovRunnerWithInterface__ class, create a void method named __compareMethods__ that runs a __MarkovModel__ and an __EfficientMarkovModel__. In particular, 
- Make both order-2 Markov models
- Use seed 42 and set the length of text to generate to be 1000
- Both should call __runModel__ that generates random text three times for each.
- Run the __MarkovModel__ first and then the __EfficientMarkovModel__ with the file __hawthorne.txt__ as the training text. One of them should be noticeably faster. You can calculate the time each takes by using __System.nanoTime()__ for the current time.