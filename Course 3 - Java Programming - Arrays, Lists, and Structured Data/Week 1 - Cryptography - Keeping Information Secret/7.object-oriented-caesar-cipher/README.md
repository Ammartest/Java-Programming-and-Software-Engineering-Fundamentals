# Programming Exercise: Object Oriented Caesar Cipher

## Assignment 1: One Key
In this assignment, you will put together the __CaesarCipher__ class from the lesson and add a __decrypt__ method to decrypt with the same key. In addition you will create a second class, TestCaesarCipher to test examples that use the __CaesarCipher__ class, including writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.

Specifically, you should do the following.

Create the CaesarCipher class with the following parts:
- Private fields for the __alphabet__ and __shiftedAlphabet__
- Write a constructor __CaesarCipher__ that has one int parameter __key__. This method should initialize all the private fields of the class.
- Write an __encrypt__ method that has one String parameter named __input__. This method returns a String that is the input encrypted using __shiftedAlphabet__.
- Write a __decrypt__ method that has one String parameter named __input__. This method returns a String that is the encrypted String decrypted using the key associated with this __CaesarCipher__ object. One way to do this is to create another private field __mainKey__, which is initialized to be the value of __key__. Then you can create a __CaesarCipher__ object within __decrypt__: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).

Create the __TestCaesarCipher__ class with the following parts:
- Include the methods __countLetters__ and __maxIndex__ that you wrote in the previous lesson.
- Write the void method __simpleTests__ that has no parameters. This method should read in a file as a String, create a __CaesarCipher__ object with key 18, encrypt the String read in using the __CaesarCipher__ object, print the encrypted String, and decrypt the encrypted String using the __decrypt__ method.
- Write the method __breakCaesarCipher__ that has one String parameter named __input__. This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson), then create a __CaesarCipher__ object with that key and decrypt the message.
- In the __simpleTests__ method, add a call to __breakCaesarCipher__ on the encrypted String to decrypt it automatically by determining the key, and print the decrypted String.

## Assignment 2: Two Keys
In this assignment, you will put together the __CaesarCipherTwo__ class that encrypts a message with two keys (the same way as the previous lesson: __key1__ is used to encrypt every other letter, starting with the first, and __key2__ is used to encrypt every other letter, starting with the second), and also decrypts the same message. In addition you will create a second class, __TestCaesarCipherTwo__ to test examples that use the __CaesarCipherTwo__ class, including writing a method that will automatically decrypt an encrypted file by determining the two keys that were used to encrypt it. 

Specifically, you should do the following.

Create the __CaesarCipherTwo__ class with the following parts:
- Include private fields for the __alphabet__, __shiftedAlphabet1__, and __shiftedAlphabet2__.
- Write a constructor __CaesarCipherTwo__ that has two int parameters __key1__ and __key2__. This method should initialize all the private fields.
- Write an __encrypt__ method that has one String parameter named __input__. This method returns a String that is the input encrypted using the two shifted alphabets.
- Write a __decrypt__ method that has one String parameter named __input__. This method returns a String that is the encrypted String decrypted using the __key1__ and __key2__ associated with this __CaesarCipherTwo__ object. You might want to add more private fields to the class.

Create the __TestCaesarCipherTwo__ class with the following parts:
- Include the methods __halfOfString__, __countLetters__, and __maxIndex__ that you wrote in the previous lesson.
- Write the void method __simpleTests__ that has no parameters. This method should read in a file as a String, create a __CaesarCipherTwo__ object with keys 17 and 3, encrypt the String using the __CaesarCipherTwo__ object, print the encrypted String, and decrypt the encrypted String using the __decrypt__ method.
- Write the method __breakCaesarCipher__ that has one String parameter named __input__. This method should figure out which keys were used to encrypt this message (in a similar manner as before), then create a __CaesarCipherTwo__ object with that key and decrypt the message.
- In the __simpleTests__ method, add a call to __breakCaesarCipher__ on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.