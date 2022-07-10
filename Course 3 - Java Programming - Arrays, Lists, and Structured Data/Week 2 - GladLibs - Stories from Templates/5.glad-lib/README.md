# Programming Exercise: Using GladLibs

## Assignment: Verbs and Fruits
Run the __GladLib.java__ program that is provided. You should also have a __data__ folder with several files. This program should generate a story using the file __madtemplate.txt__, which is also in the __data__ folder. This program creates a story by replacing placeholder words such as `<noun>` by looking for a random word of that type. This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. For example, one ArrayList stores different nouns. These nouns are initially read in from a file called __noun.txt__ and stored in the ArrayList named __nounList__. Whenever the templated word `<noun>` is found in the story, a random noun from the __nounList__ is used in place of `<noun>`. 

You will now modify the __GladLib.java__ file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:
- Modify the program to handle replacing verbs with `<verb>` tags and fruits with `<fruit>` tags. You will read in choices of verbs from the file __verb.txt__ and choices for fruit from the file __fruit.txt__. These files are already in the __data__ folder. There are several parts of the program that you will need to modify.
- Add private ArrayLists, one for verbs and one for fruits.
- Modify the method __initializeFromSource__ to read the data from these two files.
- Modify the method __getSubstitute__ to handle the replacements of `<verb>` and `<fruit>` with random words of those types.
- Modify the file __makeStory__ to read in the template file __madtemplate2.txt__ that also uses the `<verb>` and `<fruit>` tags.
- Run your program to make sure it works before making additional changes.
- Now modify your program so that once it uses a word, it never uses that word again. You should declare and initialize an additional private ArrayList to keep track of words that have been seen. HINT: You will need to modify the method __processWord__. Once it finds a word to use, check to see if that word has been used before or not. You should also be sure that you clear out this new ArrayList in __makeStory__ before each run of your program. The folder __datalong__ with longer data files is provided.
- Modify your program to print out the total number of words that were replaced right after the story is printed.