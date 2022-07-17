# Programming Exercise: Generating Random Text

Resource Link:  http://www.dukelearntoprogram.com/course4/index.php 

For the following assignments, you will start with the files provided that include several data files. 

First there are two classes provided:

The class __MarkovZero__, from the lesson, has two private variables, a String __myText__, for the training text, and __myRandom__, a random number generator. It also has a constructor to initialize __myRandom__ and three methods:
- The void method __setRandom__ has one integer parameter named __seed__. Using this method will allow you to generate the same random text each time, which will help in testing your program.
- The void method __setTraining__ has one String parameter named __s__. The String __s__ is used to initialize the training text. It is important that you DO NOT change this line or it may affect your output: `myText = s.trim();`
- The __getRandomText__ method has one integer parameter named __numChars__. This method generates and returns random text that is __numChars__ long. Remember, for __MarkovZero__, this class generates each letter by randomly choosing a letter from the training text.

The class __MarkovRunner__ has two methods.
- The void method __runMarkovZero__ has no parameters. This method reads in a file the user chooses, creates a __MarkovZero__ object, and then generates three sets of randomly generated text using the file read in to choose the random characters from.
- The void method __printOut__ is called by __runMarkovZero__ to print out the random text that was generated with around 60 characters per line. DO NOT CHANGE THIS METHOD. You’ll need output generated in this format for some of the quiz questions.

For this assignment, you will create several other Markov classes to generate text that use characters that follow other characters to predict the next possible character. The more characters you use in the prediction, the more likely the text will appear like the training text.

## Assignment 1: MarkovZero and MarkovOne
For this assignment you will first experiment with the __MarkovZero__ class, and then create a __MarkovOne__ class.

Specifically, for this assignment, you will:
- Create __MarkovZero__ generated texts by running the method __runMarkovZero__ in __MarkovRunner__. Run the program twice and note that the output is different each time you run it.
- Modify the __runMarkovZero__ method to call the __setRandom__ method with the seed 42. Run this method at least twice. What do you observe? Now change to seed to 101. Run it at least twice. You should get different text than you got with the seed 42, but every time you run it you get the same text. 
- Create a new class called __MarkovOne__. Copy the body of __MarkovZero__ into __MarkovOne__. You’ll only need to change the name of the constructor to __MarkovOne__ and add the same import that __MarkovZero__ had, and then it should compile. Right now, __MarkovOne__ is only doing what __MarkovZero__ did, since it is a copy of it. We will fix it shortly to use one character to predict text. 
- In the class __MarkovRunner__, make a copy of the method __runMarkovZero__, and name this method __runMarkovOne__. Then change the line `MarkovZero markov = new MarkovZero();` to `MarkovOne markov = new MarkovOne();`.

Try running the __runMarkovOne__ method. It should compile and do exactly what r__unMarkovZero__ did.

Now let’s fix up the class __MarkovOne__ to generate text randomly by predicting the next character based on one character that follows somewhere in the training text.
- In the class __MarkovOne__, write the method __getFollows__ that has one String parameter named __key__. This method should find all the characters from the private variable __myText__ in __MarkovOne__ that follow key and put all these characters into an ArrayList and then return this ArrayList. This algorithm for this method was described in “Finding Follow Sets.” For example, if myText were “this is a test yes this is a test.”, then the call __getFollows(“t”)__ should return an ArrayList with the Strings “h”, “e”, “ “, “h”, “e”, “.” as “t” appears 6 times. The call __getFollows(“e”)__ should return an ArrayList with the Strings “s”, “s”, “s”. Your method should work even if key is a word. Thus, __getFollows(“es”)__ should return an ArrayList with the Strings “t”, “ “, “t”. Next we will write a method to test this method.
- Create a new class in this project named __Tester__ and a void method in this class named __testGetFollows__ with no parameters. This method should create a MarkovOne object, set the training text as “this is a test yes this is a test.”. Then have it call __getFollows__ and print out the resulting ArrayList and also its size. Be sure to test it on the three examples above and also on the Strings “.” and “t.”, which occur at the end of the String. 
- Now let’s test __getFollows__ on a file. In the __Tester__ class, write the void method __testGetFollowsWithFile__ with no parameters. This method should create a MarkovOne object, set the training text to a file the user selects (similar to the methods in MarkovRunner), and then call __getFollows__. Run your program on __confucius.txt__ and look for the characters that follow “t”. You should get 11548. 
- In the class __MarkovOne__ modify the method __getRandomText__ so that it works for the way it should for MarkovOne. It should predict the next character, by finding all the characters that follow the current character in the training text, and then randomly picking one of them as the next character. 
- You already modified the __runMarkovOne__ method in the class __MarkovRunner__. Run this method with the random seed as 42 and the file __confucius.txt__. The first line of MarkovOne random text generated starts with:   
  ```
  nd are, Prevedowalvism n thastsour tr ndsang heag ti. the ffinthe
  ```

## Assignment 2: MarkovFour and MarkovModel
For this assignment you will randomly generate text by predicting possible next characters based on all the characters that follow a substring in the training text, where the substring is made up of more than one character.

Specifically, for this assignment, you will:
- Create the class __MarkovFour__ to use four characters to predict the next character. Copy and paste in MarkovOne and then modify it. You can watch the video “Implementing Order-Two” on how to create MarkovTwo from MarkovOne. 
- In the __MarkovRunner__ class, create the method __runMarkovFour__ to generate random text using the __MarkovFour__ class. If you set the random seed with 25 and run this method on __confucius.txt__, the first line of text should start with: 
  ```
  ouses the people Minister said the that a many Project of it
  ```
- Create the class __MarkovModel__ to use N characters to predict the next character. An integer should be passed in with the constructor to specify the number of characters to use to predict the next character. Copy and paste in __MarkovFour__ and then modify it.
- In the __MarkovRunner__ class, create the method __runMarkovModel__ to generate random text using the __MarkovModel__ class. If you set the random seed with 38 and run this method with N = 6 on __confucius.txt__, the first line of text should start with: 
  ```
  sters I could thrice before downloading, and his lord, might
  ```