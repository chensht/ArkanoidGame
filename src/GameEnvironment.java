import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a game environment which contains a list of collidable objects.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * a constructor of game environment by create new collidable collection.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * this method add a collidable object to the game environment by adding it to the list.
     *
     * @param c the collidable object we adding.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * this method remove a collidable object from the game environment by removing it from the list.
     *
     * @param c the collidable object we removing.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * this method get a line that represent the moving of an object and check if this object collide with
     * any of the collidables in this collection.
     * if there is no collide at all, return null.
     * else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (collidables.size() == 0) { // if there is no collidable objects at all
            return null;
        } else {
            List<Point> closePoints = new ArrayList<Point>();
            List<Collidable> closeCollidables = new ArrayList<Collidable>();
            for (Collidable c : collidables) { // check if the is a collide
                Point p1 = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
                if (p1 != null) { // if there is
                    closePoints.add(p1); // add the collision point to a list
                    closeCollidables.add(c); // add also the "shape" of collidable himself
                }
            }
            if (closePoints.size() == 0) { // if there is no collides at all
                return null;
            } else {
                Point closestPoint = closePoints.get(0);
                Collidable closestCollidable = closeCollidables.get(0);
                for (int i = 0; i < closePoints.size(); i++) { // find out which one is the closest one
                    if (closePoints.get(i).distance(trajectory.start()) < closestPoint.distance(trajectory.start())) {
                        closestPoint = closePoints.get(i);
                        closestCollidable = collidables.get(i);
                    }
                }
                CollisionInfo closestCollision = new CollisionInfo(closestPoint, closestCollidable);
                return closestCollision;
            }

        }
    }
}

