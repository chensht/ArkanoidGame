/**
 * this class save the information about a collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * a constructor of collision info by a point and collidable object.
     *
     * @param p the collision point
     * @param c the collision object.
     */
    public CollisionInfo(Point p, Collidable c) {
        this.collisionPoint = p;
        this.collisionObject = c;
    }

    /**
     * this method return the collision point.
     *
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * this method return the collision object.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}