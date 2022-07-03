# Try It! Upload and Display an Image

## Create the prototype web page
1. `Create a new pen, and add the following HTML elements`: 1 header, 1 canvas (with an ID), 1 text type input (with an ID), 1 button type input (with value and onclick attributes—the onclick event handler should call an `upload()` function you will write later)

2. `Practice CSS by adding formatting commands` such as: (a) a font family or color for the header and body; (b) a margin for the web page; (c) dimensions and a border for the canvas; (d) a font size for the input elements

3. `Add the JavaScript function upload() in the JS panel`. This function should:
- Create a variable that gets the value of the text from the text input element, and
- Display this text in an alert.

## Adapt the page to upload an image
1. `Delete the text and button inputs`.

2. `Create a file input element`. Make sure the file input:
- Accepts only single files
- Accepts only image files
- Has an ID

3. `Adapt the upload() function to use the file input to display an image`. Your function should also:
- Get the file input.
- Create a SimpleImage from the chosen file. The SimpleImage library can be found at https://www.dukelearntoprogram.com/course1/common/js/image/SimpleImage.js. Remember you will need to use the <script src=’ ‘></script> tags in the HTML pane to tell your web page where to find the Simple Image library.
- Get the canvas element, and draw the image on the canvas. Note that you can define only one of the width or height of the canvas to avoid changing the image aspect ratio.