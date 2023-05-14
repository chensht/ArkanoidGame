import biuoop.DrawSurface;

/**
 * This class represents the pause screen.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * a constructor of a pause screen.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * this method draws frame of the pause screen animation to a given surface.
     * @param d the surface to draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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