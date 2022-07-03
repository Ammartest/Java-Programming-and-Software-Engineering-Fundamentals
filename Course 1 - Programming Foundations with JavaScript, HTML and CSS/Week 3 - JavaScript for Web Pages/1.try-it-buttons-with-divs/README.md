# Try It! Buttons with Divs

Throughout this lesson on “Event-Driven Programming,” you will create and build upon a web page where you will practice adding interactive elements with JavaScript.

## Review HTML and CSS
1. `Add HTML elements, including at least one heading and two div elements`. Add some text inside your heading and divs. Keep it simple.
2. `Give each div its own different ID`.
3. `Use CSS to style headers and divs in general`. Try using a CSS property you have not used before! Consider changing: 
   - Color
   - Background color
   - Font family
   - Font size
   - Border
   - Padding
   - Margin
4. `Use CSS to style the ID for each div`.

## Add interactivity with buttons 
1. `In the HTML panel, an input element`, using the `<input> tag`, setting the type to “button”, and giving the button a value and ID.

2. `Now make the button do something by adding an onclick event handler`.
   - `To make the button interactive, add an alert`. The alert JavaScript code follows the onclick event handler. You can have your alert say whatever you would like. Now, when the button is clicked, your alert message should pop up on your screen.
   - `Next, replace your alert code with a function that calls the alert`. Define a function in the JS panel that creates an alert; and, in the HTML panel, change the event handler for onclick to now call your new function. Again, when the button is clicked, your alert message should pop up on your screen.

## Extra Challenge! 
In the JS panel, create a second function that calls confirm instead of alert. Confirm is similar to the alert box, except confirm also gives the user has the option to choose OK or Cancel. Also add the following steps to your function.

1. `Create a variable, choice`, that gets the result of user input using the confirm method.
2. `Add a condition:`  
   - If the user chooses ‘OK,’ create a variable, message, that gets the string "You pressed OK!". Hint: If the user chose ‘OK’, this means that the output of the confirm method is equal to a Boolean value of true.
   - Otherwise, create a variable, message, that gets the string "Are you sure you want to cancel?"

3. `Create an alert box that displays message`.
Now have your the onclick event handler in the HTML pane call your second function (with confirm) instead of your first function. Test to see if you first get the confirm box pop up when you click your button, followed by the alert box pop up.