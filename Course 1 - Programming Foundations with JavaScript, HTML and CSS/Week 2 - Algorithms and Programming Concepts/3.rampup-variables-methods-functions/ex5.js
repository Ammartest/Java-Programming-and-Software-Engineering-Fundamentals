/* Exercise 5 - Print the RGB values of a pixel */

// write your code here
function printPixel(nameImage, xpos, ypos) {
    var someImg = new SimpleImage(nameImage);
    var red = someImg.getRed(xpos, ypos);
    var green = someImg.getGreen(xpos, ypos);
    var blue = someImg.getBlue(xpos, ypos);

    print('red is ' + red);
    print('green is ' + green);
    print('blue is ' + blue);
}

printPixel("drewgreen.png", 10, 10);
printPixel("drewgreen.png", 250, 500);