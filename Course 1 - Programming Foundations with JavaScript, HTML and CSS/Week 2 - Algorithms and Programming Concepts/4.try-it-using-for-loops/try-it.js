// Make a 200x200 image
var img = new SimpleImage(200, 200);
print(img);

// Change the image's color to yellow
for (var pixel of img.values()) {
    pixel.setRed(255);
    pixel.setGreen(255);
    pixel.setBlue(0);
}
print(img);

// Change the image's color to magenta
for (var pixel of img.values()) {
    pixel.setRed(255);
    pixel.setGreen(0);
    pixel.setBlue(255);
}
print(img);