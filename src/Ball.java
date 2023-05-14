import biuoop.DrawSurface;

import java.awt.Color;

/**
 * this class represents a ball object.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor of ball that get the center point of the ball, its radius and color.
     *
     * @param center the center point of the ball.
     * @param r      the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * another constructor of ball that get the x and y values of the center point of the ball, its radius and color.
     *
     * @param xCenter the x value of the center point.
     * @param yCenter the y value of the center point.
     * @param r       the radius of the ball.
     * @param color   the color of the ball.
     */
    public Ball(double xCenter, double yCenter, int r, Color color) {
        this.center = new Point(xCenter, yCenter);
        this.radius = r;
        this.color = color;
    }

    /**
     * this method returns the x value of the center point of the ball.
     *
     * @return x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * this method returns the y value of the center point of the ball.
     *
     * @return y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * this method returns the radius of the ball.
     *
     * @return the radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * this method returns the color of this point.
     *
     * @return color of the ball.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * this method draw a black ball on the given DrawSurface.
     *
     * @param surface the draw surface for the ball.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }


    /**
     * this method notifies the ball that a time unit passed and calling the moveOneStep method.
     */
    @Override
    public void timePassed() {
        moveOneStep();

    }

    /**
     * this method set the velocity of the ball by the x and y values of the velocity.
     *
     * @param dx the velocity of the X axis.
     * @param dy the velocity of the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * this method return the velocity of the ball.
     *
     * @return velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * this method set the velocity of the ball by the velocity values itself.
     *
     * @param v the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * this method get the game environment of the ball.
     *
     * @return the game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * this method set game environment to this ball.
     *
     * @param g the game environment we want to set.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * this method  moves the ball one step by the information about his collisions with other objects.
     * if there is no collision, the ball will moves to the next point according to its velocity.
     * if there is collision, the ball will moves to the to almost the next point according to its velocity,
     * and the method will call to the hit method for changing its velocity accordingly.
     */
    public void moveOneStep() {

        Line line = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        if (this.getGameEnvironment().getClosestCollision(line) == null) { // if there is no collision
            this.center = this.getVelocity().applyToPoint(this.center);
        } else { // if there is collision
            double x = this.getGameEnvironment().getClosestCollision(line).collisionPoint().getX()
                    - this.velocity.getDx();
            double y = this.getGameEnvironment().getClosestCollision(line).collisionPoint().getY()
                    - this.velocity.getDy();
            this.center = new Point(x, y); // the new point that the ball will be
            Velocity v = this.getGameEnvironment().getClosestCollision(line).collisionObject().hit(this,
                    this.getGameEnvironment().getClosestCollision(line).collisionPoint(), this.velocity);
            this.setVelocity(v); // setting the new velocity created bt the hit method
        }
    }


    /**
     * this method add this ball to the game by the interface sprite.
     *
     * @param g the game we are adding the ball into;
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this method remove this ball from the game by the interface sprite.
     *
     * @param g the game we are removing the ball from;
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}

