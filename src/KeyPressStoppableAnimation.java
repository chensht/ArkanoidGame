import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is a decorator pattern the stop an animation.
 *
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * a constructor of a Key Press Stoppable Animation from a given animation, keyboard sensor and key.
     * @param sensor the  keyboard sensor.
     * @param key the key that stops the animation.
     * @param animation the given animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.sensor = sensor;
        this.key = key;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * this method draws one frame of the animation to a given surface.
     * if a key pressed, this method act accordingly.
     * @param d the surface to draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (isAlreadyPressed) {
                return;
            }
            this.stop = true;
        } else {
            this.isAlreadyPressed = false;
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