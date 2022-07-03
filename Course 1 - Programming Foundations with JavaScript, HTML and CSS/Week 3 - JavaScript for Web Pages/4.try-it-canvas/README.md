# Try It! Canvas

## Create Canvas Elements
1. `Fork your previous practice pen`, so that you start with two div elements and several buttons.

2. `In the HTML pane, change each div element to a canvas element`. While canvas elements have different functionality than divs, they can both appear as rectangles when a background color is set. Note that the text disappears, since text must be created differently on a canvas.

3. `In the HTML and JS panes, remove all but the “Change Color” button and any related functions`. You can also remove text between the canvas tags, since it will not appear.

4. `Specify a width and height for canvas elements in the CSS panel`.

5. `Check that your “Change Color” button still works`.

Change Canvas Colors with Buttons
1. In the HTML panel, create two buttons, one for each of two colors you choose (e.g., red and blue). Do not worry about the event handler yet.

2. In the JS panel, write two doColor() functions in the JS panel (e.g., doRed() and doBlue()). For each one:

Get the left canvas element.

Then use the style.backgroundColor property to change the background color. Previously you changed the color by changing the CSS class; this is an alternative way to change a color property.

3. Have your two new buttons each call the appropriate doColor() functions.

## Add Shapes and Text to Canvas
In order to draw shapes or write text on a canvas, you need to get its context. In this exercise, choose one of your `doColor()` functions and follow these steps to add functionality.

1. `Use the canvas.getContext("2d") method to get the context of the canvas`. 

2. `Draw a rectangle`. Remember to use the context.fillStyle and context.fillRect methods. You can determine the color and size of your rectangles.

3. `Try adding text to your canvas`. You will need to use the context.fillStyle, context.font, and context.fillText methods.

## Extra Challenge!
1. See what happens when you use the second button to change the background color—the background color changes, but the rectangles and text remain in the canvas.

2. Add functionality to your second `doColor()` function so that the canvas context is cleared. Get the context, and use the `context.clearRect()` method to do this. See below example.

3. If you would like to experiment with other canvas drawing capabilities, here is a resource: http://www.w3schools.com/html/html5_canvas.asp.