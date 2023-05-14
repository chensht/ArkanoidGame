/**
 * this class represents a point object.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor of point with two values.
     *
     * @param x this is the value of X in the point.
     * @param y this is the value of Y in the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this method calculates the distance between two points and returns it.
     *
     * @param p1 this is the point we calculate the distance from.
     * @return distance between the two points.
     */
    public double distance(Point p1) {
        double num = ((this.x - p1.x) * (this.x - p1.x)) + ((this.y - p1.y) * (this.y - p1.y));
        return Math.sqrt(num);
    }

    /**
     * this method checks if the points are equal.
     *
     * @param p1 this is the point we compare to.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point p1) {
        return ((this.x == p1.x) && (this.y == p1.y));
    }

    /**
     * this method returns the x value of this point.
     *
     * @return x value.
     */
    public double getX() {
        return this.x;
    }

    /**
     * this method returns the y value of this point.
     *
     * @return y value.
     */
    public double getY() {
        return this.y;
    }
}