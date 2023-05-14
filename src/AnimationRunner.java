import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * this class running the animation.
 */
public class AnimationRunner {
    private GUI gui;
    private Sleeper sleeper;
    private int framesPerSecond;

    /**
     * a constructor of animation runner from a given gui object.
     * @param gui the given gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.sleeper = new Sleeper();
        this.framesPerSecond = 60;
    }

    /**
     * this method actually running the animation given.
     * @param animation the animation given to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}