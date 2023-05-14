import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a sprite objects collection which contains a list of sprite objects.
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection;

    /**
     * a constructor of nes sprite collection.
     */
    public SpriteCollection() {
        this.spriteCollection = new ArrayList<Sprite>();
    }

    /**
     * this method add a sprite object to the sprite collection by adding it to the list.
     *
     *  @param s the sprite object we adding.
     */
    public void addSprite(Sprite s) {
        this.spriteCollection.add(s);
    }

    /**
     * this method remove a sprite object from the sprite collection by removing it from the list.
     *
     *  @param s the sprite object we removing.
     */
    public void removeSprite(Sprite s) {
        this.spriteCollection.remove(s);
    }

    /**
     * this method notifies to all objects in the collection that a time unit passed.
     * by calling timePassed method on all sprite objects.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteCollection.size(); i++) {
            this.spriteCollection.get(i).timePassed();
        }
    }

    /**
     * this method draw all the sprite objects on a given surface.
     * by calling drawON method on all sprite objects.
     *
     * @param d the surface the sprite objects will be draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteCollection) {
            s.drawOn(d);
        }
    }
}
