import biuoop.DrawSurface;
/**
 * this interface represents animation.
 */
public interface Animation {

    /**
     * this method draws one frame of the animation to a given surface.
     * @param d the surface to draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method return true if the animation should stop and false otherwise.
     * @return true if the animation should stop, false otherwise.
     */
    boolean shouldStop();
}