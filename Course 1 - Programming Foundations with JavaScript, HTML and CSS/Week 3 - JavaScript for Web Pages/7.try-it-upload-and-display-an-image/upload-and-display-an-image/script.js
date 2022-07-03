function upload() {
    //Get input from text input
    var imgcanvas = document.getElementById("can");
    var fileinput = document.getElementById("finput");
    var filename = fileinput.value;
    var image = new SimpleImage(fileinput);

    //Draw image on canvas
    image.drawTo(imgcanvas);

    // Alert displaying text
    alert("You choose " + filename);
}