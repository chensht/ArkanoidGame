/**
 * this class represent the velocity in X and Y axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor of velocity using two values, X axis value and Y axis values of movements.
     *
     * @param dx the X axis value of movement.
     * @param dy the Y axis value of movement.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this method is working like a constructor of velocity using two values, angles and speed.
     * by using math func (radians,sin,cos) the method will calculate the dx and dy of the velocity,
     * than will use the regular velocity for create one.
     *
     * @param angle the angle of the movement.
     * @param speed the speed of the movement.
     * @return the velocity value by dx and dy values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radianAngle = Math.toRadians(angle);
        double dx = (Math.sin(radianAngle) * speed);
        double dy = (Math.cos(radianAngle) * speed);
        return new Velocity(dx, dy);
    }

    /**
     * this method returns the dx value of velocity (the value of X axis).
     *
     * @return dx value of velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * this method returns the dy value of velocity (the value of Y axis).
     *
     * @return dy value of velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * this method get a point (x,y) and return a new point that changed according to the dx and dy values.
     *
     * @param p point in the form of (x,y).
     * @return new point (x+dx, y+dy).
     */

    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

}