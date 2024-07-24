public class Square {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int calculateArea() {
        if(side <= 0)
            return -1;
        return side * side;
    }

    public int calculatePerimeter() {
        if(side <= 0)
            return -1;
        return 4*side;
    }

}
/*
 * Instructions
 * Implement the Square constructor. This constructor should take an integer argument and initialize the side attribute with the value of this argument.
 * Implement the calculateArea() method. If the side attribute is less than or equal to zero, return -1. Otherwise, calculate and return the area of the square using the formula: side * side.
 * Implement the calculatePerimeter() method. If the side attribute is less than or equal to zero, return -1. Otherwise, calculate and return the perimeter of the square using the formula: 4 * side.
 */