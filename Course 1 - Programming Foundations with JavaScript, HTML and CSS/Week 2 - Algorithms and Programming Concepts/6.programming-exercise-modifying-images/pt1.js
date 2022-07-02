/* Part 1 */

var image = new SimpleImage("hilton.jpg");
var width = image.getWidth();
var stripeLimit = width / 3;

for (var pixel of image.values()) {
    var currentX = pixel.getX();

    if (currentX < stripeLimit) {
        pixel.setRed(255);
    } else if (currentX >= stripeLimit) {
        if (currentX < stripeLimit * 2) {
            pixel.setGreen(255);
        } else {
            pixel.setBlue(255);
        }
    }
}

print(image);