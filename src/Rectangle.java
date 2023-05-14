import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a rectangle object.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;


    /**
     * a constructor of rectangle by his upperLeft point, width and height.
     *
     * @param upperLeft the upper left of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * a constructor of a rectangle by his upperLeft point x and y values, width and height.
     *
     * @param x      the x value of the rectangle upper left point.
     * @param y      the y value of the rectangle upper left point.
     * @param width  the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * this method return a list of the lines of rectangle.
     *
     * @return the list of the rectangle's lines.
     */
    public List<Line> linesOfRectangle() {
        Line up = new Line(this.getUpperLeft(), this.getUpperRight());
        Line down = new Line(this.getLowerLeft(), this.getLowerRight());
        Line left = new Line(this.getUpperLeft(), this.getLowerLeft());
        Line right = new Line(this.getUpperRight(), this.getLowerRight());
        List<Line> rectangleLines = new ArrayList<Line>();
        rectangleLines.add(up);
        rectangleLines.add(down);
        rectangleLines.add(left);
        rectangleLines.add(right);

        return rectangleLines;
    }

    /**
     * this method return a list of intersection points with the specified line.
     * if there is no intersection points the method will return null.
     *
     * @param line the line we check intersection with.
     * @return the list of the intersection points.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        List<Line> rectangleLines = linesOfRectangle();
        for (Line l1: rectangleLines) { // for every line of the rectangle
            if (l1.isIntersecting(line)) { // if this line is intersecting with given line
                intersectionPoints.add(l1.intersectionWith(line)); // add this intersection point to the list
            }
        }
        if (intersectionPoints.size() == 0) { // if there is no intersection point at all
            return null;
        } else {
            return intersectionPoints;
        }
    }

    /**
     * this method return the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this method return the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * this method return the upper left point of the rectangle.
     *
     * @return the upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * this method return the upper right point of the rectangle.
     *
     * @return the upper right point.
     */
    public Point getUpperRight() {
        Point upperRight = new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY());
        return upperRight;
    }

    /**
     * this method return the lower left point of the rectangle.
     *
     * @return the lower left point.
     */
    public Point getLowerLeft() {
        Point lowerLeft = new Point(this.upperLeft.getX(), (this.upperLeft.getY() + height));
        return lowerLeft;
    }

    /**
     * this method return the lower right point of the rectangle.
     *
     * @return the lower right point.
     */
    public Point getLowerRight() {
        Point lowerRight = new Point((this.upperLeft.getX() + this.width), (this.upperLeft.getY() + height));
        return lowerRight;
    }


}