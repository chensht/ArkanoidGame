import biuoop.DrawSurface;

import java.awt.Color;
//I.D 318731411

/**
 * this class represent a score indicator object.
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;
    private Rectangle scoreRec;

    /**
     * a constructor of score indicator object by a score counter.
     * @param score the score counter.
     */
    public ScoreIndicator(Counter score) {
        this.currentScore = score;
        this.scoreRec = new Rectangle(0, 0, 800, 25);
    }

    /**
     * this method draws the score indicator on a given surface.
     * @param d the surface the object will be draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle((int) this.scoreRec.getUpperLeft().getX(), (int) this.scoreRec.getUpperLeft().getY(),
                (int) this.scoreRec.getWidth(), (int) this.scoreRec.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.scoreRec.getUpperLeft().getX(), (int) this.scoreRec.getUpperLeft().getY(),
                (int) this.scoreRec.getWidth(), (int) this.scoreRec.getHeight());
        d.drawText(500, 20, "Score : " + this.currentScore.getValue(), 15);
    }

    /**
     * this method notifies the score indicator that a time unit passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * this method add this score indicator to a given game by the interface sprite.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
