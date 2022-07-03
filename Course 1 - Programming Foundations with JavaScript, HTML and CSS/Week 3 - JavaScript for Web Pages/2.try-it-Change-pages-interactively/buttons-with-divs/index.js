function dochange() {
  alert("clicked button with JS");
  console.log("It works");
}

function getChoice() {
  var message = "Press a button!\nEither OK or Cancel.";
  var choice = confirm(message);

  if (choice == true) {
    message = "You pressed OK!";
  } else {
    message = "Are you sure you want to cancel?";
  }

  alert(message);
}

function changeColor() {
  var divElement1 = document.getElementById("div1");
  var divElement2 = document.getElementById("div2");
  
  divElement1.className = "blueback";
  divElement2.className = "orangeback";
}

function changeText() {
  var divElement1 = document.getElementById("div1");
  var divElement2 = document.getElementById("div2");

  divElement1.innerHTML = "Erste";
  divElement2.innerHTML = "Zweite";
}

function changeTextColor() {
  var divElement1 = document.getElementById("div1");
  var divElement2 = document.getElementById("div2");

  divElement1.style.color = "aquamarine";
  divElement2.style.color = "purple";
}

function changeButtonText() {
  var btnElement1 = document.getElementById("btn1");
  var btnElement2 = document.getElementById("btn2");
  var btnElement3 = document.getElementById("btn3");
  var btnElement4 = document.getElementById("btn4");

  btnElement1.value = "using classes";
  btnElement2.value = "using .innerHTML property";
  btnElement3.value = "using .style.color property";
  btnElement4.value = "using .value property";
}