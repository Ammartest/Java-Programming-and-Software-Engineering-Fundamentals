// write your code here
var x = 3;
var y = 4;
var z = x + 2 * y;

print(x); // 3
print(y); // 4
print(z); // 11
print();

var x = 3;
var y = 2;
y = x;
print(x); // 3
print(y); // 3
print();

var image = new SimpleImage("smallpanda.png");
print(image);
print(image.getWidth());
print(image.getHeight());
// For getPixel(), getRed(), getGreen(), and getBlue() methods to work, you need to pass the cordinates of a pixel.
print(image.getPixel(24, 10));
print(image.getRed(24, 10), ' ', image.getGreen(24, 10), ' ', image.getBlue(24, 10));

function square(x) {
	var ans = x * x;
	return ans;
}

function cube(x) {
	var ans = x * x * x;
	return ans;
}

var s = square(4);
print(s);

var c = cube(2);
print(c);
