/* Exercise 4 - Perimeter of an image */

// write your code here
function perimeter(imageName) {
    var someImg = new SimpleImage(imageName);
    var height = someImg.getHeight();
    var width = someImg.getWidth();
    var answer = (height + width) * 2;

    return answer;
}

print(perimeter("rodger.png"));