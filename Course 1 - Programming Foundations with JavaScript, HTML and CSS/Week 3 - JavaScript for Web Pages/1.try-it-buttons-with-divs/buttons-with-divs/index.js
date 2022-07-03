function dochange() {
    alert('clicked button with JS');
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