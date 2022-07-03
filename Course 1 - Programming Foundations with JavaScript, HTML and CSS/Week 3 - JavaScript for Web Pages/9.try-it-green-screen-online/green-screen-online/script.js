var fgImage = null;
var bgImage = null;
var fgCanvas;
var bgCanvas;

function loadForegroundImage() {
    var file = document.getElementById("fgfile");
    fgImage = new SimpleImage(file);
    fgCanvas = document.getElementById("fgcan");
    fgImage.drawTo(fgCanvas);
}

function loadBackgroundImage() {
    var file = document.getElementById("bgfile");
    bgImage = new SimpleImage(file);
    bgCanvas = document.getElementById("bgcan");
    bgImage.drawTo(bgCanvas);
}

function createComposite() {
    //Create a new image with the dimensions of the foreground image
    //Returns the composite green screen image
    var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());
    var greenThreshold = 240;

    for (var pixel of fgImage.values()) {
        var x = pixel.getX();
        var y = pixel.getY();
        if (pixel.getGreen() > greenThreshold) {
            //Pixel is green, use background
            var bgPixel = bgImage.getPixel(x, y);
            output.setPixel(x, y, bgPixel);
        } else {
            //Pixel is not green, use foreground
            output.setPixel(x, y, pixel);
        }
    }

    return output;
}

function doGreenScreen() {
    //Check that images are loaded
    if (fgImage == null || !fgImage.complete()) {
        alert("Foreground image not loaded");
    }
    if (bgImage == null || !bgImage.complete()) {
        alert("Background image not loaded");
    }

    //Clear canvases
    clearCanvas();

    //Call createComposite, which does green screen algorithm and returns a composite image
    var finalImage = createComposite();
    finalImage.drawTo(fgCanvas);
}

function doClear(canvas) {
    var context = canvas.getContext("2d");
    context.clearRect(0, 0, canvas.width,canvas.height);
}

function clearCanvas() {
    doClear(fgCanvas);
    doClear(bgCanvas);
}