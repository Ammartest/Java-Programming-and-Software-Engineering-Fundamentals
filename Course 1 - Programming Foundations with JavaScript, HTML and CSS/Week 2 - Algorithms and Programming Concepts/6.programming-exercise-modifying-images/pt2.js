/* Part 2 */

function swapRedGreen(pixel) {
    var red = pixel.getRed();
    var green = pixel.getGreen();

    pixel.setRed(green);
    pixel.setGreen(red);
}


var img = new SimpleImage("smalluniverse.jpg");
// print(img);

for (pixel of img.values()) {
    swapRedGreen(pixel);
}
print(img);

var img = new SimpleImage("smallhands.png");
// print(img);

for (pixel of img.values()) {
    swapRedGreen(pixel);
}
print(img);