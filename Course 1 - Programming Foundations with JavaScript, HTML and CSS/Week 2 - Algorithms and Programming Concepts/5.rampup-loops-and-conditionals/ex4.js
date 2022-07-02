/* Exercise 4 - Add Thick Black Line to Bottom of Owen */

var image = new SimpleImage("astrachan.jpg");
var newHeight = image.getHeight() - 11;

for (var pixel of image.values()) {
    if (pixel.getY() >= newHeight) {
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(0);
    }
}

print(image);