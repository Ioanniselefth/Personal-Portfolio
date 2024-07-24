// Defining a Point class to represent a point in 2-dimensional space
public class Point {
    
    // x-coordinate of the point
    private int x;

    // y-coordinate of the point
    private int y;

    // Constructor for the Point class
    public Point(int x, int y) {
        this.x = x;  // Assigning x-coordinate of the point
        this.y = y;  // Assigning y-coordinate of the point
    }

    // Method to get the x-coordinate of the point
    public int getX() {
        return x;
    }

    // Method to get the y-coordinate of the point
    public int getY() {
        return y;
    }

    // Implement the method to move the point by dx and dy in x and y direction respectively
    public void move(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    // Implement the method to calculate the distance from this point to another point
    public double distanceTo(Point other) {
        return Math.sqrt((Math.pow((other.x-this.x),2) + Math.pow((other.y-this.y),2)));
    }
}