/* Exercise 3 - Number of pixels in an image */

// write your code here
function numberPixels(namefile) {
    var someImg = new SimpleImage(namefile);
    var height = someImg.getHeight();
    var width = someImg.getWidth();
    var answer = height * width;

    return answer;
}

var result = numberPixels("chapel.png");
print(result);
result = numberPixels("dinos.png");
print(result);