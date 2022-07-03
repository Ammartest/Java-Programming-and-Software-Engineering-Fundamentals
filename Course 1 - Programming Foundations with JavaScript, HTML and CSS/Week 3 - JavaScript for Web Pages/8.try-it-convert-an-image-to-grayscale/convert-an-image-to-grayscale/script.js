var imgcanvas = document.getElementById("can1");
var fileinput = document.getElementById("finput");
var grayscalecanvas = document.getElementById("can2");
// var image;
var originalimage;
var grayscaleimage;

function upload() {
    //Get the input image
    var filename = fileinput.value;
    alert("You choose " + filename);

    // Draw the input image to both canvas
    originalimage = new SimpleImage(fileinput);
    originalimage.drawTo(imgcanvas);
    
    grayscaleimage = new SimpleImage(fileinput);
    grayscaleimage.drawTo(grayscalecanvas);
    
}

function makeGray() {
    for (var pixel of originalimage.values()) {
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3
        pixel.setRed(avg);
        pixel.setGreen(avg);
        pixel.setBlue(avg);
    }

    var grayscalecanvas = document.getElementById("can2");
    originalimage.drawTo(grayscalecanvas);
}