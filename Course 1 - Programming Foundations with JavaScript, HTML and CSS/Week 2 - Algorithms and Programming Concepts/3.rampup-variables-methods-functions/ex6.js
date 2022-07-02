/* Exercise 6 - Sum of the RGB values for a Pixel */

// write your code here
function sumPixel(nameOfImage, xpos, ypos) {
    var someImg = new SimpleImage(nameOfImage);
    var red = someImg.getRed(xpos, ypos);
    var green = someImg.getGreen(xpos, ypos);
    var blue = someImg.getBlue(xpos, ypos);

    // print(red, green, blue);

    return (red + green + blue);
}

var answer = sumPixel("drewgreen.png", 250, 500);
print(answer);
answer = sumPixel("drewgreen.png", 10, 10);
print(answer);