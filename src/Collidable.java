/**
 * The interface Collidable, represent a collidable object.
 */
public interface Collidable {
    /**
     * this method return the "collision shape" of the object.
     *
     * @return the collision "collision shape".
     */
    Rectangle getCollisionRectangle();

    /**
     * this method notify the object that we collided with it at given collisionPoint with a given velocity.
     * the method return the new velocity after it change it according to the hit.
     *
     * @param hitter the hitter ball.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity of the object that hit the collidable object.
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}