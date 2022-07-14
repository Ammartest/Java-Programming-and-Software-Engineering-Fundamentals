# Programming Exercise: Sorting at Scale

Resource Link:  http://www.dukelearntoprogram.com/course4/index.php 

For the following assignments, you will start with the files provided, using most of the classes, and modifying only a few of them.  

First there are several classes provided from the previous lesson that are unchanged:
- The class __Location__, from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.
- The class __QuakeEntry__, from the lesson, which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a __toString__ method. It also has a __compareTo__ method to sort earthquakes by magnitude (and commented out code that previously sorted earthquakes by distance to a location). You will be modifying the __compareTo__ method in the first assignment. 
- The class __EarthQuakeParser__, from the lesson, which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.

There are several new classes
- The __DifferentSorters__ class includes several methods that are similar to code shown in the videos to test several of the classes/methods in this assignment. You’ll be adding additional tester methods to this class.  
- The __MagnitudeComparator__ class implements Comparator to allow one to sort QuakeEntry’s by magnitude from smallest to largest magnitude. This method was mentioned in a video.
- The __DistanceComparator__ class implements Comparator to allow one to sort QuakeEntry’s by their distance to a specified location that is passed in as a parameter. This method was also mentioned in a video. 

## Assignment 1: compareTo Method
In this assignment, you will modify the __compareTo__ method to sort quakes in a different way. 

Specifically, for this assignment, you will: 
- Modify the __compareTo__ method in the QuakeEntry class. (You may want to comment out the current code first). The __compareTo__ method should now sort quake by magnitude first, from smallest magnitude to largest magnitude, and then break ties (use == operator to determine whether magnitudes are equal) by depth, from smallest (most negative) depth to largest depth.
- Test the __compareTo__ method by running the __sortWithCompareTo__ method in the DifferentSorters class with any data file. The sort used is __Collections.sort__. You should be able to see that the earthquakes are sorted by magnitude, and those with the same magnitude are sorted by depth. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) by adding the following code at the end of this method, after sorting and printing out all the elements.
  ```java
  int quakeNumber = 10;
  System.out.println("Print quake entry in position " + quakeNumber);
  System.out.println(list.get(quakeNumber));
  ```
  When you run your method on the file __nov20quakedata.atom__, the element in position 10 that is printed should be:
  ```
  (36.75, -116.15), mag = -0.20, depth = -4200.00, title = 57km ESE of Beatty, Nevada
  ```
  *This output has been modified to reflect the updated EarthQuakeParser class, 1/12/16. 

## Assignment 2: Title Comparator
In this assignment, you will write a Comparator to sort earthquakes by title first and break ties by depth. 

Specifically, for this assignment, you will: 
- Write the __TitleAndDepthComparator__ class that implements a Comparator of type QuakeEntry. In this class you should write the compare method that has two parameters, a QuakeEntry named __q1__ and a QuakeEntry named __q2__. This method should compare the title of __q1__ and __q2__. If __q1__’s title comes before __q2__’s title in alphabetical order, then this method should return a negative integer. If __q1__’s title comes after __q2__’s title, then this method should return a positive integer. If __q1__’s title is the same as __q2__’s title, then this method should compare the depth of the two earthquakes. If __q1__’s depth is less than __q2__’s depth, then this method should return a negative number. If __q1__’s depth is greater than __q2__’s depth, then this method should return a positive integer. Otherwise, this method should return 0. 
- Write the void method __sortByTitleAndDepth__ in the __DifferentSorters__ class. This method should create an EarthQuakeParser, read data from a file on earthquakes and create an ArrayList of QuakeEntry’s. Then this method should call __Collections.sort()__ on this ArrayList and use the __TitleAndDepthComparator__ to sort the earthquakes. You should be able to see that the earthquakes are sorted by title first, and those with the same title are sorted by depth. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) after sorting and printing out all the elements.

  When you run your method on the file __nov20quakedata.atom__, the element in position 10 that is printed should be:
  ```
  (49.76, 155.83), mag = 4.70, depth = -58380.00, title = 104km SSW of Severo-Kuril'sk, Russia
  ```

## Assignment 3: Last Word in Title Comparator
In this assignment, you will write a Comparator to sort earthquakes by the last word in their title first and break ties by magnitude. 

Specifically, for this assignment, you will: 
- Write the __TitleLastAndMagnitudeComparator__ class that implements a Comparator of type QuakeEntry. In this class you should write the compare method that has two parameters, a QuakeEntry named __q1__ and a QuakeEntry named __q2__. This method should compare the last word in the title of __q1__ and __q2__. If __q1__’s last word comes before __q2__’s last word in alphabetical order, then this method should return a negative integer. If __q1__’s last word comes after __q2__’s last word, then this method should return a positive integer. If __q1__’s last word is the same as __q2__’s last word, then this method should compare the magnitude of the two earthquakes. If __q1__’s magnitude is less than __q2__’s magnitude, then this method should return a negative number. If __q1__’s magnitude is greater than __q2__’s magnitude, then this method should return a positive integer. Otherwise, this method should return 0. 
- Write the void method __sortByLastWordInTitleThenByMagnitude__ in the __DifferentSorters__ class. This method should create an EarthQuakeParser, read data from a file on earthquakes and create an ArrayList of QuakeEntry’s. Then this method should call __Collections.sort()__ on this ArrayList and use the __TitleLastAndMagnitudeComparator__ to sort the earthquakes. You should be able to see that the earthquakes are sorted by the last word in their title, and those with the same last word are sorted by magnitude. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) after sorting and printing out all the elements.

  When you run your method on the file __nov20quakedata.atom__, the element in position 10 that is printed should be:
  ```
  (64.47, -149.48), mag = 0.40, depth = -16300.00, title = 21km WSW of North Nenana, Alaska
  ```