/**
 * the interface HitListeners, represent objects listen to a hit.
 */
public interface HitListener {
    /** This method is called whenever the beingHit object is hit.
     * @param beingHit the object (block) being hit by the hitter ball.
     * @param hitter the hitter object (the ball that's doing the hitting).
     */
    void hitEvent(Block beingHit, Ball hitter);
}