# Programming Exercise: Implementing the Caesar Cipher

## Assignment 1: Word Play 
You will write a program to transform words from a file into another form, such as replacing vowels with an asterix. 

Specifically, you should do the following.
- Create a new class called WordPlay.
- Write a method __isVowel__ that has one Char parameter named __ch__. This method returns __true__ if __ch__ is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and __false__ otherwise. You should write a tester method to see if this method works correctly. For example, __isVowel(‘F’)__ should return __false__, and __isVowel(‘a’__ should return __true__.
- Write a method __replaceVowels__ that has two parameters, a String named __phrase__ and a Char named __ch__. This method should return a String that is the string __phrase__ with all the vowels (uppercase or lowercase) replaced by __ch__. For example, the call __replaceVowels("Hello World", '+')__ returns the string "H+ll+ W+rld". Be sure to call the method __isVowel__ that you wrote and also test this method.
- Write a method __emphasize__ with two parameters, a String named __phrase__ and a character named __ch__. This method should return a String that is the string __phrase__ but with the Char __ch__ (upper- or lowercase) replaced by
    - '*' if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
    - '+' if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).

  For example, the call __emphasize("dna ctgaaactga", 'a')__ would return the string "dn* ctg+*+ctg+", and the call __emphasize(“Mary Bella Abracadabra”, ‘a’)__ would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.

## Assignment 2: Caesar Cipher
You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.

Specifically, you should do the following:
- Create a new class called __CaesarCipher__.
- Write the method __encrypt__ that has two parameters, a String named __input__ and an int named __key__. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call __encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)__ should return the string “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
- Write the void method __testCaesar__ that has no parameters. This method should read a file and encrypt the complete file using the Caesar Cipher algorithm, printing the encrypted message. You may want to include the lines:
  ```java
  FileResource fr = new FileResource();
  String message = fr.asString();
  String encrypted = encrypt(message, key);
  System.out.println("key is " + key + "\n" + encrypted);
  ```
- Modify the __encrypt__ method to be able to handle both uppercase and lowercase letters. For example, __encrypt(“First Legion”, 23)__ should return “Cfopq Ibdflk”, and __encrypt(“First Legion”, 17)__ should return “Wzijk Cvxzfe”.  Be sure to test the encrypt method. 
- Write the method __encryptTwoKeys__ that has three parameters, a String named __input__, and two integers named __key1__ and __key2__. This method returns a String that has been encrypted using the following algorithm. Parameter __key1__ is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and __key2__ is used to encrypt every other character, starting with the second character. For example, the call __encryptTwoKeys(“First Legion”, 23, 17)__ should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.