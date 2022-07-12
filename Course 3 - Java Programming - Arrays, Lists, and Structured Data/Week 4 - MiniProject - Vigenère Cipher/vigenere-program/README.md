# Programming Exercise: Known Language and Key Length

## Assignment: English Language, Known Key Length
The first step of this mini-project is for you to write a program that breaks a Vigenère cipher, where you know that the language is English and the key length is also known.  

We have provided three Java classes to get you started:

__CaesarCipher__: This class provides an implementation of the Caesar cipher algorithm that you learned about earlier with public __encrypt__ and __decrypt__ methods. A few adjustments have been made to the code to make it easier for you to work with here:
- This code follows the second, object-oriented design you learned about, in which the constructor takes the key.
- The code provides public methods to encrypt or decrypt one single character __encryptLetter__ and __decryptLetter__.
- In the constructor, the alphabets are built to have upper- and lowercase letters to preserve the case of a message.
- You should test this code in a tester class that creates a CaesarCipher object and attempts to encrypt and decrypt an entire message (such as __titus-small.txt__), as well as individual characters.

__CaesarCracker__: This class provides an implementation of the Caesar cipher cracking (or breaking) algorithm that you learned about earlier. As with the __CaesarCipher__ class, a few adjustments have been made:
- The constructor takes a parameter for the most common letter, so it can be used for languages other than English.
- Finding the key has been separated from decrypting the message. You can use the method __getKey__ to pass in an encrypted message and receive the key back.
- You can test these methods in the tester class by making a new CaesarCracker object and decrypting the file __titus-small_key5.txt__ using no arguments for the constructor (default most common character ‘e’), and the file __oslusiadas_key17.txt__, noting that the most common character in Portuguese is ‘a’.

__VigenereCipher__: This class implements a Vigenère cipher. It has the following functionality:
- __public VigenereCipher(int[] key)__: the constructor, which takes a key, which is an array of integers and initializes the field ciphers, which is an array of CaesarCipher objects.
- __public String encrypt(String input)__: a method that encrypts the String passed in and returns the encrypted message.
- __public String decrypt(String input)__: a method that decrypts the String passed in and returns the decrypted message.
- __public String toString()__: returns a String representing the key for this cipher.
- You can test these methods in the tester class by creating a VigenereCipher object with the key “rome”, which is {17, 14, 12, 4} in integers and encrypting and decrypting the file __titus-small.txt__, the encrypted first line of which is “Tcmp-pxety mj nikhqv htee mrfhtii tyv”.

Your first step in this mini-project is to write the three methods in the __VigenereBreaker__ class. Specifically you should do the following:
- Write the public method __sliceString__, which has three parameters—a String __message__, representing the encrypted message, an integer __whichSlice__, indicating the index the slice should start from, and an integer __totalSlices__, indicating the length of the key. This method returns a String consisting of every __totalSlices__-th character from message, starting at the __whichSlice__-th character.
  
  You can test your method on these examples:
  ```
  sliceString("abcdefghijklm", 0, 3) should return "adgjm"

  sliceString("abcdefghijklm", 1, 3) should return "behk"

  sliceString("abcdefghijklm", 2, 3) should return "cfil"

  sliceString("abcdefghijklm", 0, 4) should return "aeim"

  sliceString("abcdefghijklm", 1, 4) should return "bfj"

  sliceString("abcdefghijklm", 2, 4) should return "cgk"

  sliceString("abcdefghijklm", 3, 4) should return "dhl"

  sliceString("abcdefghijklm", 0, 5) should return "afk"

  sliceString("abcdefghijklm", 1, 5) should return "bgl"

  sliceString("abcdefghijklm", 2, 5) should return "chm"

  sliceString("abcdefghijklm", 3, 5) should return "di"

  sliceString("abcdefghijklm", 4, 5) should return "ej"
  ```

- Write the public method __tryKeyLength__, which takes three parameters—a String __encrypted__ that represents the encrypted message, an integer __klength__ that represents the key length, and a character __mostCommon__ that indicates the most common character in the language of the message. This method should make use of the __CaesarCracker__ class, as well as the __sliceString__ method, to find the shift for each index in the key. You should fill in the key (which is an array of integers) and return it. Test this method on the text file __athens_keyflute.txt__, which is a scene from A Midsummer Night’s Dream encrypted with the key “flute”, and make sure you get the key {5, 11, 20, 19, 4}.
- Write the public method __breakVigenere__ with no parameters. This void method should put everything together, so that you can create a new VigenereBreaker in BlueJ, call this method on it, and crack the cipher used on a message. This method should perform 6 tasks (in this order):
  1. Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).
  2. Use the __asString__ method to read the entire contents of the file into a String.
  3. Use the __tryKeyLength__ method, which you just wrote, to find the key for the message you read in. For now, you should just pass ‘e’ for __mostCommon__.
  4. You should create a new VigenereCipher, passing in the key that __tryKeyLength__ found for you.
  5. You should use the VigenereCipher’s __decrypt__ method to decrypt the encrypted message.
  6. Finally, you should print out the decrypted message!

Test this method on the text file __athens_keyflute.txt__, using key length 5. The first line should be “SCENE II. Athens. QUINCE'S house.”

# Programming Exercise: Unknown Key Length

## Assignment: English Language, Unknown Key Length
Now that you have broken Vigenère ciphers with a known key length, it is time to expand your program’s functionality to break Vigenère ciphers of unknown key length. You will do this by adding three methods to your __VigenereBreaker__ class, and then modifying your __breakVigenere__ method. 

Specifically, you should do the following:
- In the __VigenereBreaker__ class, write the public method __readDictionary__, which has one parameter—a FileResource __fr__. This method should first make a new HashSet of Strings, then read each line in __fr__ (which should contain exactly one word per line), convert that line to lowercase, and put that line into the HashSet that you created. The method should then return the HashSet representing the words in a dictionary. All the dictionary files, including the English dictionary file, are included in the starter program you download. They are inside the folder called ‘dictionaries’.
- In the __VigenereBreaker__ class, write the public method __countWords__, which has two parameters—a String __message__, and a HashSet of Strings __dictionary__. This method should split the message into words (use __.split(“\\W+”)__, which returns a String array), iterate over those words, and see how many of them are “real words”—that is, how many appear in the dictionary. Recall that the words in __dictionary__ are lowercase. This method should return the integer count of how many valid words it found.
- In the __VigenereBreaker__ class, write the public method __breakForLanguage__, which has two parameters—a String __encrypted__, and a HashSet of Strings __dictionary__. This method should try all key lengths from 1 to 100 (use your __tryKeyLength__ method to try one particular key length) to obtain the best decryption for each key length in that range. For each key length, your method should decrypt the message (using VigenereCipher’s __decrypt__ method as before), and count how many of the “words” in it are real words in English, based on the dictionary passed in (use the __countWords__ method you just wrote). This method should figure out which decryption gives the largest count of real words, and return that String decryption. Note that there is nothing special about 100; we will just give you messages with key lengths in the range 1–100. If you did not have this information, you could iterate all the way to __encrypted.length()__. Your program would just take a bit longer to run.
- Finally, you need to modify your __breakVigenere__ method to make use of your new code. The steps below describe what your __breakVigenere__ method should do. They are similar to the steps from the previous portion of this project but have been updated: _new items are in italics_, [and old items that you should no longer do are in square brackets.]
  1. Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).
  2. Use that FileResource’s __asString__ method to read the entire contents of the file into a String.
  3. _You should make a new FileResource_ to read from the English dictionary file that we have provided. [Use the __tryKeyLength__ method that you just wrote to find the key for the message you read in. For now, you should just pass ‘e’ for __mostCommon__.]
  4. _You should use your __readDictionary__ method to read the contents of that file into a HashSet of Strings_. [You should create a new VigenereCipher, passing in the key that __tryKeyLength__ found for you.]
  5. _You should use the __breakForLanguage__ method that you just wrote to decrypt the encrypted message_. [You should use a VigenereCipher object to decrypt the encrypted message.]
  6. Finally, you should print out the decrypted message!
  7. Test this method on the text file __athens_keyflute.txt__. The first line should be “SCENE II. Athens. QUINCE'S house”, and the key is “flute”, or {5, 11, 20, 19, 4}. This file contains 376 valid words out of 386 (total word count ignores whitespace). 

# Programming Exercise: Unknown Language, Unknown Key Length

## Assignment: Multiple Languages
Finally, it is time to expand your program so that it can crack messages in other languages. To accomplish this, you need to write two new methods and modify two methods you have already written.

Specifically, you should do the following:
- In the __VigenereBreaker__ class, write the public method __mostCommonCharIn__, which has one parameter—a HashSet of Strings __dictionary__. This method should find out which character, of the letters in the English alphabet, appears most often in the words in __dictionary__. It should return this most commonly occurring character. Remember that you can iterate over a HashSet of Strings with a for-each style for loop.
- In the __VigenereBreaker__ class, write the public method __breakForAllLangs__, which has two parameters—a String __encrypted__, and a HashMap, called __languages__, mapping a String representing the name of a language to a HashSet of Strings containing the words in that language. Try breaking the encryption for each language, and see which gives the best results! Remember that you can iterate over the __languages.keySet()__ to get the name of each language, and then you can use __.get()__ to look up the corresponding dictionary for that language. You will want to use the __breakForLanguage__ and __countWords__ methods that you already wrote to do most of the work (it is slightly inefficient to re-count the words here, but it is simpler, and the inefficiency is not significant). You will want to print out the decrypted message as well as the language that you identified for the message.
- Modify the method __breakForLanguage__ to make use of your __mostCommonCharIn__ method to find the most common character in the language, and pass that to __tryKeyLength__ instead of ‘e’.
- Modify your __breakVigenere__ method to read many dictionaries instead of just one. In particular, you should make a HashMap mapping Strings to a HashSet of Strings that will map each language name to the set of words in its dictionary. Then, you will want to read (using your __readDictionary__ method) each of the dictionaries that we have provided (Danish, Dutch, English, French, German, Italian, Portuguese, and Spanish) and store the words in the HashMap you made. Reading all the dictionaries may take a little while, so you might add some print statements to reassure you that your program is making progress. Once you have made that change, you will want to call __breakForAllLangs__, passing in the message (the code to read in the message is unchanged from before), and the HashMap you just created.

Test your program on the file __athens_keyflute.txt__. Notice that the correct key “flute” {5, 11, 20, 19, 4} is detected for English, French, Danish, German, and Dutch, due to ‘e’ being the most common character and the languages having cognates, but English has the greatest number of valid words for its decryption.