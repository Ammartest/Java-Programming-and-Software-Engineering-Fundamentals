function doBlue() {
    var canvas = document.getElementById("can1");
    canvas.style.backgroundColor = "blue";

    var context = canvas.getContext("2d");

    context.fillStyle = "yellow";
    context.fillRect(10,10,60,60);
    context.fillRect(80,10,60,60);

    context.fillStyle = "black";
    context.font = "20px Arial";
    context.fillText("Hello", 15, 45);
}

function doOrange() {
    var canvas = document.getElementById("can1");
    var context = canvas.getContext("2d");
    context.clearRect(0,0,canvas.width,canvas.height);
    canvas.style.backgroundColor = "orange";
}