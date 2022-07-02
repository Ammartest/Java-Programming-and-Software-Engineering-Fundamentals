/* Optional: One Change */
/* It worked! I did it! */

function updatedChangeRed(width, height, blue, green) {
    var picture = new SimpleImage(width, height);
    var red = 0;

    for (var pixel of picture.values()) {
        pixel.setRed(red);
        pixel.setGreen(blue);
        pixel.setBlue(green);
        if (red < 255) {
            red = red + 1;
        } else {
            red = 0;
        }
    }

    return picture;
}

var result = updatedChangeRed(256, 200, 200, 100);
print(result);