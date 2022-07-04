function crop(image, width, height) {
    var newimage = new SimpleImage(width, height);
    
    for (var pixel of image.values()) {
        var x = pixel.getX();
        var y = pixel.getY();
        
        if ((x < width) && (y < height)) {
            var oldpixel = image.getPixel(x, y);
            newimage.setPixel(x, y, oldpixel);
        }
    }
    
    return newimage;
}

var origional = new SimpleImage("astrachan.jpg")
var cropped = crop(origional, 200, 300);
print(origional);
print(cropped);