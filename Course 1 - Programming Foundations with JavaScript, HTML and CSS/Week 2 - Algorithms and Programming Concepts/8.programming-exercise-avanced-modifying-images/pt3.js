// write your code here
/* Part 3 */

function setBlack(pixel) {
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
}

function addBorder(image, thickness) {
    var width = image.getWidth();
    var height = image.getHeight();
    
    for (pixel of image.values()) {
        var x = pixel.getX();
        var y = pixel.getY();
        
        if (x < thickness || x >= width - thickness) {
            setBlack(pixel);
        }
        
        if (y < thickness || y >= height - thickness) {
            setBlack(pixel);
        }
    }
}

var img = new SimpleImage("smallpanda.png");
addBorder(img, 10);
print(img);