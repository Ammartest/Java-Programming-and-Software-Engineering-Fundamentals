# Try It! Using Variables, Methods and Functions

Try experimenting a little with the DukeLearnToProgram (DLTP) JavaScript programming environment to get comfortable with beginning to write JavaScript! Here is a link to the environment: http://www.dukelearntoprogram.com/course1/example/index.php (also available from the course Resources tab).

## Experimenting with Variables and Creating a SimpleImage
Try the example you saw in the `Variables` video of creating and initializing three variables: 
```javascript
var x = 3;
var y = 4;
var z = x + 2*y;
```
Add code to print out x, y, and z and note their values.

Next, if you wrote the following code, what do you think would be the values of x and y printed? Try it and see!  
```javascript
var x = 3;
var y = 2;
y = x;
print (x);
print (y);
```
Next, create and print a new SimpleImage from one of the images in the environment, for example:
```javascript
var image = new SimpleImage(“chapel.png”);
```
Note that there are many different images available in the DLTP JavaScript programming environment in the “Available Images” area. You can drag and drop other images from your computer into the “Available Images” area and create a SimpleImage by just replacing “chapel.png” with whichever file name that shows up in “Available Images”.

## Experimenting with Methods
Create a new SimpleImage from one of the images in the environment. Then, experiment with the following methods:
- getWidth 
- getHeight 
- getPixel 
- getRed, getGreen, getBlue

For example, you may want to print the width and height of your image, and print the red, green, and blue values of a particular pixel, such as the pixel at coordinates (0,0).

## Experimenting with Functions
Write the function you saw in the `Functions` video:
```javascript
function square(x){
	var ans = x*x;
	return ans;
}
```
Also write the following line of code you saw in the `Functions` video that calls the square function on the value 4 and stores the result in the variable y:
```javascript
var y = square(4);
```
Print out y. Call the square function on a few numbers other than 4. 

## Extra Challenge!
What if you wanted to turn your square function into a cube function? What would you change about the square function to turn it into a function that returns the cube of a number? (For example, calling your cube function on 2 should give the result 8 because 2x2x2 = 8) You might also want to change the name from square to cube to make it clearer what your function does.

Make a function of your own. It can do whatever you want! If you don’t have an idea for a function right now, you could use one of these suggestions: 

Write a function that adds three numbers together.

Write a function that adds two strings. Remember that addings strings means concatenating, so “a” + “b” is “ab” and “b” + “a” is “ba”.

Write a function that prints the width and height of an image.