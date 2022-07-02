/* Part 3 */

var image = new SimpleImage("duke_blue_devil.png");
print(image);

for (var pixel of image.values()) {
    if (pixel.getRed() !== 255) {
        if (pixel.getGreen() !== 255) {
            if (pixel.getBlue() !== 255) {
                pixel.setRed(255);
                pixel.setGreen(255);
                pixel.setBlue(0);
            }
        }
    }
}

print(image);