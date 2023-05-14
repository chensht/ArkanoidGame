import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This class represents the end of the game screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean isWin;
    private Counter score;
    private boolean stop;

    /**
     * a constructor of an end screen.
     *
     * @param k   the keyboard sensor.
     * @param winOrLoose boolean win or loose variable.
     * @param score    the final score at the end of the game.
     */
    public EndScreen(KeyboardSensor k, Boolean winOrLoose, Counter score) {
        this.keyboard = k;
        this.isWin = winOrLoose;
        this.score = score;
        this.stop = false;
    }

    /**
     * this method draws frame of the end screen animation to a given surface.
     * if the player won or loose the match end screen appears.
     * @param d the surface to draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!isWin) {
            d.drawText(10, d.getHeight() / 2, "GAME OVER. Your score is: " + this.score.getValue(), 32);
        }
        if (isWin) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is: " + this.score.getValue(), 32);
        }
    }

    /**
     * this method return true if the animation should stop and false otherwise.
     * @return true if the animation should stop, false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
