# Try It! Inputs and Events

## Create a Color chooser
1. `Create a new practice Pen`.

2. `Add a heading, a canvas element to the Pen`.

3. `Add two input elements`: a button to change the background color of the canvas “on click” and a color input element that allows the user to change the color of the canvas “on change.” Note that a color input element must have a value attribute that is the hexadecimal value for a color (e.g., #0000FF). You can find the hex values for colors using this resource: http://www.w3schools.com/colors/colors_picker.asp

4. `Write a JavaScript function for the event handler of the color input that`:
   - `Gets the canvas element`;
   - `Gets the color input element`; and 
   - `Sets the canvas background color to the value of the color input`.

5. `Try changing the` _onchange_ `attribute to` _onclick_ and see how the input behaves differently.

## Create a Slider
1. `Fork your color chooser practice pen`, so that you start with a canvas element and a color chooser (you can delete the button).

2. `Add a slider input element by specifying the type “range.”` Refer to the Inputs and Events video for more details on the min, max, value, and oninput attributes.

3. `Write a function doSquare()` for the slider event handler that draws squares on the canvas, such that their side lengths are determined by the value of the slider. Your function should:
   - `Get the slider element, then its value`.
   - `Get the canvas element, then its context`.
   - `Use the` _context.fillStyle_ `and` _context.fillRect_ `methods`. Try making the position of the second square dependent on the first, such as specifying that the x-coordinate be the length plus a number, or the length times a factor. (Note that if you use the ‘+’ operator with variables JavaScript has decided are strings (words or text), you need to use parseInt to convert the string to an integer.)

