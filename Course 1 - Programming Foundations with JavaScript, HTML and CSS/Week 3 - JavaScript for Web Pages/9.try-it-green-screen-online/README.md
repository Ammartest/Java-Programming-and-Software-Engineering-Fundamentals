# Try It! Green Screen Online

## Create the prototype web page
1. `Create the prototype web page (i.e., Pen) with all necessary HTML elements`, before you connect them to the green screen JavaScript code. The page should have the following elements:
   - A heading
   - Two canvases
   - Two file input elements, labeled Foreground and Background
   - Two buttons, with values “Create Composite” and “Clear Canvases”, respectively

2. `Create event handlers for each of the input elements`, pointing each handler to a function, e.g., `loadForegroundImage()`, `loadBackgroundImage()`, `doGreenScreen()`, `clearCanvas()`.

4. `For the purposes of the prototype, have each function alert the user`, such as “foreground image loaded” and check that they each work as expected.

## Return to DLTP
1. `Consider the green screen code you wrote in the previous module`. You created image variables fgImage, bgImage, and output. Then you looked at each pixel in fgImage to determine how to set the corresponding pixel in output. Finally you printed output.

2. `Think about which part of this code needs to be executed in the upload functions` and where the filename you wrote explicitly will come from.

3. `Think about which part of this code needs to be executed after clicking “Create Composite”`.

4. `Think about which variables should be global`, once the rest of the code is contained in functions.

5. `Finally, think about how you will “print” on the web page`.

6. `Write an outline of how your HTML, JavaScript, and CSS will be written` to accomplish the above steps.

## Implement Green Screen
1. `Create global variables for the foreground image` and background image. You can also create global variables for the canvas elements, since several functions will need to access them. 
   - Initialize these global variables to null, so that you will be able to check if they are complete.

2. `Modify your load image functions so that`:
   - The foreground image variable is initialized to the selected image and displayed in the left panel.
   - The background image is initialized to the selected image and displayed in the right panel. 
   - Remember: What do you need to do in order to use SimpleImage in this pen?

3. `Modify the clearCanvas() function to clear both canvases`. Recall the `clearRect` method you used in a previous Try It! exercise.

4. `Begin writing your doGreenScreen() function with a set of conditionals`.
   - Check to see if the foreground image is null  (i.e., `== null`) OR if the foreground image has not finished loading (i.e., `! fgImage.complete()`); if either of these conditions are true, alert the user that the image has not been loaded.
   - Create a similar conditional statement for the background image.
   - Otherwise, have the function clear both canvases and execute the following green screen algorithm.

5. `Write the green screen algorithm in your doGreenScreen() function`.
   - As part of the final conditional in Point 4, initialize a variable that is a “blank” new SimpleImage with the dimensions of the foreground image.
   - Add your green screen algorithm code, making sure to reference your uploaded foreground and background images and newly created final image.
   - Specify a green threshold value that you will use to determine if a pixel is “green.” Note that there are many ways to define “green.” You can use a green threshold value, such as 240 used in this lesson, or you can compare the green to the sum of red and blue, as in the last module, or you can devise a way of your choosing.
   - The rest of the for loop should be familiar from the code you have written previously.

6. Draw the final composite image to the right canvas.

You can also consider adding checks to your code to display an error message if the images are different sizes. You could also check their sizes and trim one to be the dimensions of the other.

Now test your web page’s code. Go to the DLTP JavaScript enviornment (http://www.dukelearntoprogram.com/course1/example/index.php, also linked in the Resources tab) and download the “dinos.png” and “drewrobert.png” image files in the “Available Images” section (both images are 1920x1080). Upload these images to your web page and see if your green screen code works!