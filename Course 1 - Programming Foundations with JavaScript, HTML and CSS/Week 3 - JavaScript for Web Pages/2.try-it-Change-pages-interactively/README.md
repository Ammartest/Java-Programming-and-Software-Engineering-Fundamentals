# Try It! Change Pages Interactively

For this exercise, you will be building off of your previous exercise.

## Style divs background-color using classes
From your last Pen, you should have styled your divs using IDs and CSS. If you had styled the background-color in the CSS for the IDs, remove this background coloring code.

Next, add a different class to each of your divs.

Now, style the background-color of each of your divs by styling the classes in the CSS pane.

## Change Div Background Color with Buttons
1. `In the CSS pane, style an extra 1-2 new classes`, giving the classes a new background-color you have not yet used in your Pen.

2. `In the JS pane, create a new function, changeColor()`.
   - `Have the function access each div by the div’s ID`. For each div, create a variable that gets that div by using the document.getElementById(“divID”) method.
   - `Change each div’s class`. Use the .className property to change the class for each div element. Change each div’s class so that the background-color changes for each div.

3. `In the HTML pane, update your button`. Change the value of your input element to “Change Color” and have the button call the changeColor() function when the button is clicked.

## Change Div Text Content with Buttons
1. `In the HTML pane, add a new button`. Make the input’s value “Change Text”. Don’t worry about the event handler (e.g., onclick) yet.

2. `In the JS pane, create a new function changeText()`. This function should:
   - Access each div element by its ID;
   - Use the .innerHTML method to change the text to something new inside each div.

3. `In the HTML pane, have your “Change Text” button call the changeText() function`.

## Extra Challenge!
Now try changing other aspects of the web page when a button is clicked. Consider:
- Changing the div with the `.style.color` property
- Changing the `value` attribute of a button