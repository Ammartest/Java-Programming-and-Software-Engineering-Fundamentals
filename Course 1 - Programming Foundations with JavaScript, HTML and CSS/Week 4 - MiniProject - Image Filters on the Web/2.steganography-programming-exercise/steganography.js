// Steganography

/* Important Notes: This program has not been tested thoroughly. It basically represents the main idea. */


function clearbits(colorval) {
    // Compute the same color value with the low bits zeroed
    var x = Math.floor(colorval / 16) * 16;
    return x;
}

function chop2hide(image) {
    // For each pixel in the image
    for (var px of image.values()) {
        // Clear the low bits of the red
        px.setRed(clearbits(px.getRed()));
        // Clear the low bits of the green
        px.setGreen(clearbits(px.getGreen()));
        // Clear the low bits of the blue
        px.setBlue(clearbits(px.getBlue()));
    }
    
    // After doing each pixel, return the image as the answer
    return image;
}

function shift(image) {
    // For each pixel in the image
    for (var px of image.values()) {
        // Shift the red bits over
        px.setRed(px.getRed() / 16);
        // Shift the green bits over
        px.setGreen(px.getGreen() / 16);
        // Shift the blue bits over
        px.setBlue(px.getBlue() / 16);
    }
    // After doing each pixel, return the image as the answer
    return image;
}

function combine(show, hide) {
    // Make a new image the same size as "show" (call it answer)
    var answer = new SimpleImage(show.getWidth(), show.getHeight());
    
    // For each pixel in answer
    for (var px of answer.values()) {
        // Get the x and y of that pixel
        var x = px.getX();
        var y = px.getY();
        
        // Get the pixel in the same place from show
        var showPixel = show.getPixel(x, y);
        // Get the pixel in the same place from hide
        var hidePixel = hide.getPixel(x, y);
        
        // Set the red of px to the sum of showPixel's red + hidePixel's red
        px.setRed(showPixel.getRed() + hidePixel.getRed());
        // Set the green of px to the sum of showPixel's green + hidePixel's green
        px.setGreen(showPixel.getGreen() + hidePixel.getGreen());
        // Set the blue of px to the sum of showPixel's blue + hidePixel's blue
        px.setBlue(showPixel.getBlue() + hidePixel.getBlue());
    }
    
    // After doing each pixel, return answer of the image
    return answer;
}

var start = new SimpleImage("usain.jpg");
var hide = new SimpleImage("skyline.jpg");

start = chop2hide(start);
hide = shift(hide);
var ans = combine(start, hide);
print(ans);
print(start);
print(hide);
