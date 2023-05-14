import java.awt.Color;
import java.util.List;

/**
 * this class represent the information of a level.
 */
public interface LevelInformation {
    /**
     * this method returns the number of balls in this level.
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * this method returns a list of the velocities of the balls.
     * @return list of the velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * this method returns a list of the balls.
     * @return list of the balls.
     */
    List<Ball> balls();

    /**
     * this method returns the paddle width.
     * @return paddle width.
     */
   int paddleWidth();

    /**
     * this method returns the level name.
     * @return level name.
     */
    String levelName();

    /**
     * this method returns the background of the level.
     * @return the background.
     */
    Block getBackground();

    /**
     * this method returns a list of the blocks.
     * @return  list of the blocks.
     */
    List<Block> blocks();
    /**
     * this method returns the number of blocks in the level.
     * @return number of blocks.
     */
    int numberOfBlocksToRemove();

    /**
     * this method returns the background color of the level.
     * @return background color.
     */
    Color backgroundColor();
}
