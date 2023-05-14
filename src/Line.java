import java.util.List;

/**
 * this class represents a line object.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor of line with two points.
     *
     * @param start a point that represents the start point of the line.
     * @param end   a point that represents the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * another constructor of line with four values that represent two points.
     *
     * @param x1 this is the value of X in one point, will be the start point.
     * @param y1 this is the value of Y in one point, will be the start point.
     * @param x2 this is the value of X in other point, will be the end point.
     * @param y2 this is the value of Y in other point, will be the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * this method calculates the length of the line by the distance method of the Point class and returns it.
     *
     * @return line's length.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * this method calculates the middle point of the line and returns it.
     *
     * @return middle point.
     */
    public Point middle() {
        double xMid = ((this.start.getX() + this.end.getX()) / 2);
        double yMid = ((this.start.getY() + this.end.getY()) / 2);
        Point middle = new Point(xMid, yMid);
        return middle;
    }

    /**
     * this method returns the start point of the line.
     *
     * @return start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * this method returns the end point of the line.
     *
     * @return end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * this method checks if 2 lines are intersect by checking and comparing the slopes.
     * we will refer to the lines as equations and find the intersection point between them,
     * than will check if it in the range of the segments.
     *
     * @param l1 the line we want to check intersection with.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line l1) {
        double m1 = 0;
        double m2 = 0;
        double xIntersection = 0;
        double yIntersection = 0;
        if (this.start.getX() != this.end.getX()) { //if this line is not x=c
            m1 = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
        }
        if (l1.start.getX() != l1.end.getX()) { //if this line is not x=c
            m2 = ((l1.start.getY() - l1.end.getY()) / (l1.start.getX() - l1.end.getX()));
        }
        if (m1 == m2) {
            //2 cases that one of the lines is horizontal and the other is vertical
            if ((m1 == 0) && (this.start.getX() == this.end.getX()) && (l1.start.getX() != l1.end.getX())) {
                xIntersection = this.start.getX();
                yIntersection = (((xIntersection - l1.start.getX()) * m2) + l1.start.getY());
            } else if ((m2 == 0) && (l1.start.getX() == l1.end.getX()) && (this.start.getX() != this.end.getX())) {
                xIntersection = l1.start.getX();
                yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
            }
            // 2 cases that one line starts at the end of the other
            if (this.start.equals(l1.end)) {
                xIntersection = this.start.getX();
                yIntersection = this.start.getY();
            } else if (this.end.equals(l1.start)) {
                xIntersection = this.end.getX();
                yIntersection = this.end.getY();
            }
        } else if (m1 != m2) { // check regularly if there is intersection point between the 2 equations
            if ((m1 == 0) && (this.start.getX() == this.end.getX()) && (l1.start.getX() != l1.end.getX())) {
                xIntersection = this.start.getX(); //one line is x=c
                yIntersection = (((xIntersection - l1.start.getX()) * m2) + l1.start.getY());
            } else if ((m2 == 0) && (l1.start.getX() == l1.end.getX()) && (this.start.getX() != this.end.getX())) {
                xIntersection = l1.start.getX(); //one line is x=c
                yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
            } else { //regular calculate
                xIntersection = (((m1 * this.start.getX()) - (m2 * l1.start.getX())
                        + (l1.start.getY()) - (this.start.getY())) / (m1 - m2));
                yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
            }
        }
        //  check if the intersection point is in the ranges of the lines, return true if it is and false if it is not
        return (((xIntersection <= Math.max(this.start.getX(), this.end.getX()))
                && (xIntersection <= Math.max(l1.start.getX(), l1.end.getX())))
                && ((xIntersection >= Math.min(this.start.getX(), this.end.getX()))
                && (xIntersection >= Math.min(l1.start.getX(), l1.end.getX()))))
                && (((yIntersection <= Math.max(this.start.getY(), this.end.getY()))
                && (yIntersection <= Math.max(l1.start.getY(), l1.end.getY())))
                && ((yIntersection >= Math.min(this.start.getY(), this.end.getY()))
                && (yIntersection >= Math.min(l1.start.getY(), l1.end.getY()))));
    }

    /**
     * this method calculates the intersection point between 2 lines.
     * if the lines are intersect (checking by the previous method) we will calculate the intersection point.
     *
     * @param l1 the line who intersection with.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line l1) {
        if (isIntersecting(l1)) {
            double m1 = 0;
            double m2 = 0;
            double xIntersection = 0;
            double yIntersection = 0;
            if (this.start.getX() != this.end.getX()) { //if this line is not x=c
                m1 = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
            }
            if (l1.start.getX() != l1.end.getX()) { //if this line is not x=c
                m2 = ((l1.start.getY() - l1.end.getY()) / (l1.start.getX() - l1.end.getX()));
            }
            if (m1 == m2) {
                //2 cases that one of the lines is horizontal and the other is vertical
                if ((m1 == 0) && (this.start.getX() == this.end.getX()) && (l1.start.getX() != l1.end.getX())) {
                    xIntersection = this.start.getX();
                    yIntersection = (((xIntersection - l1.start.getX()) * m2) + l1.start.getY());
                } else if ((m2 == 0) && (l1.start.getX() == l1.end.getX()) && (this.start.getX() != this.end.getX())) {
                    xIntersection = l1.start.getX();
                    yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
                }
                // 2 cases that one line starts at the end of the other
                if (this.start.equals(l1.end)) {
                    xIntersection = this.start.getX();
                    yIntersection = this.start.getY();
                } else if (this.end.equals(l1.start)) {
                    xIntersection = this.end.getX();
                    yIntersection = this.end.getY();
                }
            } else if (m1 != m2) { // check regularly if there is intersection point between the 2 equations
                if ((m1 == 0) && (this.start.getX() == this.end.getX()) && (l1.start.getX() != l1.end.getX())) {
                    xIntersection = this.start.getX(); //one line is x=c
                    yIntersection = (((xIntersection - l1.start.getX()) * m2) + l1.start.getY());
                } else if ((m2 == 0) && (l1.start.getX() == l1.end.getX()) && (this.start.getX() != this.end.getX())) {
                    xIntersection = l1.start.getX(); //one line is x=c
                    yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
                } else { //regular calculate
                    xIntersection = (((m1 * this.start.getX()) - (m2 * l1.start.getX())
                            + (l1.start.getY()) - (this.start.getY())) / (m1 - m2));
                    yIntersection = (((xIntersection - this.start.getX()) * m1) + this.start.getY());
                }
            }
            Point intersection = new Point(xIntersection, yIntersection);
            return intersection;
        } else { // there is not intersection point
            return null;
        }
    }

    /**
     * this method checks if two lines are equal by using the equals method of the Point class.
     *
     * @param l1 the line we want to compare to.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line l1) {
        return ((this.start.equals(l1.start)) && (this.end.equals(l1.end)))
                || ((this.start.equals(l1.end)) && (this.end.equals(l1.start)));
    }


    /**
     * this method check if this line is contains a given point..
     *
     * @param p the point we check if the line contains.
     * @return true if this point on the line and false otherwise.
     */
    public boolean isContains(Point p) {
        double m = 0;
        if (this.start.getX() != this.end.getX()) { //if this line is not x=c
            m = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
        }
        if (p.getY() == ((m * (p.getX() - this.start.getX())) + this.start.getY())) {
            return (p.getX() <= Math.max(this.start.getX(), this.end.getX()))
                    && (p.getX() >= Math.min(this.start.getX(), this.end.getX()))
                    && (p.getY() <= Math.max(this.start.getY(), this.end.getY()))
                    && (p.getY() >= Math.min(this.start.getY(), this.end.getY()));
        } else {
            return false;
        }
    }

    /**
     * this method return the intersection point between this line and a given rectangle
     * which is the closest to the start of this line.
     * if there is no intersection point between them, the method will return null.
     *
     * @param rect the rectangle we check intersection with.
     * @return the closest intersection point to start of line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this); // list of all the intersection points
        if (intersectionPoints == null) { // if there are no intersection point return null
            return null;
        } else if (intersectionPoints.size() == 1) { // if there is only one intersection point return it
            return intersectionPoints.get(0);
        } else {
            Point closestPoint = intersectionPoints.get(0);
            for (Point p : intersectionPoints) {
                if (this.start.distance(p) < this.start.distance(closestPoint)) {
                    closestPoint = p;
                }
            }
            return closestPoint;
        }
    }

}