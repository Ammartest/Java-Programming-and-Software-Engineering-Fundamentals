var imgcanvas = document.getElementById("can");
var fileinput = document.getElementById("finput");
var image;

function upload() {
    image = new SimpleImage(fileinput);
    image.drawTo(imgcanvas);
    
    var filename = fileinput.value;
    alert("You choose " + filename);
}

function makeGray() {
    for (var pixel of image.values()) {
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3
        pixel.setRed(avg);
        pixel.setGreen(avg);
        pixel.setBlue(avg);
    }

    var imgcanvas = document.getElementById("can");
    image.drawTo(imgcanvas);
}