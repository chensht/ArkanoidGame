import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class represents a level name.
 */
public class LevelName implements Sprite {
    private String levelName;

    /**
     * a constructor of a level name indicator from a string given.
     * @param name the given string.
     */
    public LevelName(String name) {
        this.levelName = name;
    }

    /**
     * this method draws the level name on a given surface.
     * @param d the surface the object will be draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(200, 20, "Level Name : " + levelName, 15);
    }

    /**
     * this method notifies the score indicator that a time unit passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * this method add this level name to a given game by the interface sprite.
     * @param g the game .
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
