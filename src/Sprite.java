import biuoop.DrawSurface;

/**
 * The interface Sprite, represent an object that can be draw and appear.
 */
public interface Sprite {

    /**
     * this method draw the sprite object on a given surface.
     *
     * @param d the surface the object will be draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * this method notifies the object that a time unit passed.
     */
    void timePassed();
}