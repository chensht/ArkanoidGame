import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a block object that implements the interfaces Collidable, Sprite and HitNotifier.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;


    /**
     * a constructor of a block by a rectangle.
     *
     * @param r the rectangle represent the block.
     */
    public Block(Rectangle r) {
        this.rectangle = r;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * a constructor of a block by a rectangle and color.
     *
     * @param r the rectangle represent the block.
     * @param c the color of the block.
     */
    public Block(Rectangle r, Color c) {
        this.rectangle = r;
        this.color = c;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * a constructor of a block by a rectangle, this time the rectangle represent by his upperLeft point,
     * and its width and height.
     *
     * @param upperLeft the upper left point of the rectangle represent the block.
     * @param width     the width of the rectangle represent the block.
     * @param height    the height of the rectangle represent the block.
     */
    public Block(Point upperLeft, double width, double height) {
        this.rectangle = new Rectangle(upperLeft, width, height);
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * a constructor of a block by a rectangle, this time the rectangle represent by his upperLeft point,
     * and its width and height, and color.
     *
     * @param upperLeft the upper left point of the rectangle represent the block.
     * @param width     the width of the rectangle represent the block.
     * @param height    the height of the rectangle represent the block.
     * @param c         the color of the block.
     */
    public Block(Point upperLeft, double width, double height, Color c) {
        this.rectangle = new Rectangle(upperLeft, width, height);
        this.color = c;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * a constructor of a block.
     * by a rectangle, this time the rectangle represent by his upperLeft point x and y values,
     * and its width and height, and color.
     *
     * @param xUpperLeft the x value of the upper left point of the rectangle represent the block.
     * @param yUpperLeft the y value of the upper left point of the rectangle represent the block.
     * @param width      the width of the rectangle represent the block.
     * @param height     the height of the rectangle represent the block.
     * @param c          the color of the block.
     */
    public Block(double xUpperLeft, double yUpperLeft, double width, double height, Color c) {
        Point upper = new Point(xUpperLeft, yUpperLeft);
        this.rectangle = new Rectangle(upper, width, height);
        this.color = c;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * a constructor of a block.
     * by a rectangle, this time the rectangle represent by his upperLeft point x and y values,
     * and its width and height, and color.
     *
     * @param xUpperLeft the x value of the upper left point of the rectangle represent the block.
     * @param yUpperLeft the y value of the upper left point of the rectangle represent the block.
     * @param width      the width of the rectangle represent the block.
     * @param height     the height of the rectangle represent the block.
     */
    public Block(double xUpperLeft, double yUpperLeft, double width, double height) {
        Point upper = new Point(xUpperLeft, yUpperLeft);
        this.rectangle = new Rectangle(upper, width, height);
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * this method draw a block on a given surface.
     *
     * @param surface the surface the block will be draw on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * this method notifies the block that a time unit passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * this method return this block as a collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * this method changed the velocity of an object that hit this block.
     * the velocity changed according to the collision point the method get.
     *
     * @param hitter the object (ball) hit this block.
     * @param collisionPoint  the collision point of the hit between object and this block.
     * @param currentVelocity the current velocity of the object hitting this block.
     * @return the velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if ((collisionPoint.getX() <= this.rectangle.getUpperRight().getX())
                && (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX())
                && ((collisionPoint.getY() == this.rectangle.getUpperRight().getY())
                || (collisionPoint.getY() == this.rectangle.getLowerRight().getY()))) {
            dy = ((-1) * dy); // if the point is on the top/low line of the block, flip the y coordinate of velocity.
        }
        if ((collisionPoint.getY() <= this.rectangle.getLowerLeft().getY())
                && (collisionPoint.getY() >= this.rectangle.getUpperLeft().getY())
                && ((collisionPoint.getX() == this.rectangle.getUpperLeft().getX())
                || (collisionPoint.getX() == this.rectangle.getLowerRight().getX()))) {
            dx = ((-1) * dx); //if the point is on the left/right line of the block, flip the x coordinate of velocity.
        }

        this.notifyHit(hitter);
        Velocity newVelocity = new Velocity(dx, dy);
        return newVelocity;
    }


    /**
     * this method add this block to a  game by the interfaces collidable and sprite.
     *
     * @param g the game we are adding the block into;
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * this method remove this block from the game by the interfaces collidable and sprite.
     *
     * @param g the game we are removing the block from;
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    /**
     * this method add hl as a listener to hit events.
     * @param hl the listener to hit event of this block.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * this method remove hl as a listener to hit events.
     * @param hl the listener to hit event of this block.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * this method notify all listeners about a hit event.
     * @param hitter the hitter object (a ball).
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}







