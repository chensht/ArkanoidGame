import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * this class represent a paddle object.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddleRect;
    private Color color;

    /**
     * a constructor of a paddle by a rectangle, color and keyboard sensor.
     *
     * @param rect the rectangle represent the paddle.
     * @param c the color of the paddle.
     * @param k the keyboard sensor.
     */
    public Paddle(Rectangle rect, Color c, KeyboardSensor k) {
        this.paddleRect = rect;
        this.color = c;
        this.keyboard = k;
    }

    /**
     * a constructor of a block by a rectangle, this time the rectangle represent by his upperLeft point,
     * and its width and height. color, and keyboard sensor.
     *
     * @param upperLeft the upper left point of rectangle represent the paddle.
     * @param width     the width of rectangle represent the paddle.
     * @param height    the height of rectangle represent the paddle.
     * @param c         the color of the paddle.
     * @param k the keyboard sensor.
     */
    public Paddle(Point upperLeft, double width, double height, Color c, KeyboardSensor k) {
        this.paddleRect = new Rectangle(upperLeft, width, height);
        this.color = c;
        this.keyboard = k;
    }


    /**
     * a constructor of a block by a rectangle, this time the rectangle represent by his upperLeft point x and y values,
     * and its width and height, color, keyboard sensor.
     *
     * @param xUpperLeft the x value of upper left point of rectangle represent the paddle.
     * @param yUpperLeft the y upper left
     * @param width      the width of rectangle represent the paddle.
     * @param height     the height of rectangle represent the paddle.
     * @param c          the color of the paddle.
     * @param k the keyboard sensor.
     */
    public Paddle(double xUpperLeft, double yUpperLeft, double width, double height, Color c, KeyboardSensor k) {
        Point upper = new Point(xUpperLeft, yUpperLeft);
        this.paddleRect = new Rectangle(upper, width, height);
        this.color = c;
        this.keyboard = k;
    }

    /**
     * this method moves the paddle left.
     */
    public void moveLeft() {
        double newX = this.paddleRect.getUpperLeft().getX() - 5;
        double newY = this.paddleRect.getUpperLeft().getY();
        if (newX < 25) { //the limit of screen
            newX = 25;
        }
        this.paddleRect = new Rectangle(newX, newY, this.paddleRect.getWidth(), this.paddleRect.getHeight());
    }

    /**
     * this method moves the paddle left.
     */
    public void moveRight() {
        double newX = this.paddleRect.getUpperLeft().getX() + 5;
        double y = this.paddleRect.getUpperLeft().getY();
        if (newX > (775 - this.paddleRect.getWidth())) { //the limit of screen
            newX = (775 - this.paddleRect.getWidth());
        }
        this.paddleRect = new Rectangle(newX, y, this.paddleRect.getWidth(), this.paddleRect.getHeight());
    }


    /**
     * this method notifies the paddle that a time unit passed.
     * if the left key is pressed, calls the moveLeft method.
     * if the left key is pressed, calls the moveRight method.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * this method draw a paddle on a given surface.
     *
     * @param d the surface the paddle will be draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.paddleRect.getUpperLeft().getX(), (int) this.paddleRect.getUpperLeft().getY(),
                (int) this.paddleRect.getWidth(), (int) this.paddleRect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.paddleRect.getUpperLeft().getX(), (int) this.paddleRect.getUpperLeft().getY(),
                (int) this.paddleRect.getWidth(), (int) this.paddleRect.getHeight());
    }


    /**
     * this method return this paddle as a collision rectangle.
     *
     * @return the collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddleRect;
    }

    /**
     * this method changed the velocity of an object that hit this block.
     * the velocity changed according to the part of the paddle that the collision point on.
     *
     * @param hitter the object (ball) the hit this paddle.
     * @param collisionPoint  the collision point of the hit between object and this paddle.
     * @param currentVelocity the current velocity of the object hitting this paddle.
     * @return the velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double speed = Math.sqrt((dx * dx) + (dy * dy));
        double xOfPaddle = this.paddleRect.getUpperLeft().getX();
        double xOfColl = collisionPoint.getX();
        double width = (this.paddleRect.getWidth() / 5);

        if (xOfColl >= xOfPaddle && xOfColl < xOfPaddle + width) {
            return Velocity.fromAngleAndSpeed(300, -speed);

        } else if (xOfColl >= xOfPaddle + width && xOfColl < xOfPaddle + 2 * width) {
            return Velocity.fromAngleAndSpeed(330, -speed);

        } else if (xOfColl >= xOfPaddle + 2 * width && xOfColl < xOfPaddle + 3 * width) {
            return Velocity.fromAngleAndSpeed(360, -speed);

        } else if (xOfColl >= xOfPaddle + 3 * width && xOfColl < xOfPaddle + 4 * width) {
            return Velocity.fromAngleAndSpeed(30, -speed);

        } else { // if(xOfColl >= xOfPaddle + 4 * width && xOfColl <= xOfPaddle + 5 * width)
            return Velocity.fromAngleAndSpeed(60, -speed);
        }
    }

    /**
     * this method add this paddle to a game by the interfaces collidable and sprite.
     *
     * @param g the game we are adding the paddle into;
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}


