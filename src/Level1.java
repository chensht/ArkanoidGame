import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the first level.
 */
public class Level1 implements LevelInformation {
   private List<Velocity> velocities;
    private List<Block> blocks;
    private List<Ball> balls;
    private Block background;

    /**
     * a constructor of the first level.
     */
    public Level1() {
        this.velocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
        this.balls = new ArrayList<Ball>();
        this.background = new Block(0, 0, 800, 600, Color.black);
    }

    /**
     * this method returns the number of balls in this level.
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * this method returns a list of the velocities of the balls.
     * @return list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
      this.velocities.add(new Velocity(0, 3));
        return this.velocities;
    }

    /**
     * this method returns a list of the balls.
     * @return list of balls.
     */
    @Override
    public List<Ball> balls() {
        this.balls.add(new Ball(400, 300, 5, Color.white));
        return balls;
    }

    /**
     * this method returns the paddle width.
     * @return paddle width.
     */
    @Override
    public int paddleWidth() {
        return 80;
    }

    /**
     * this method returns the level name.
     * @return level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * this method returns the background of this level.
     * @return background of this level.
     */
    @Override
    public Block getBackground() {
        return this.background;
    }

    /**
     * this method returns a list of the blocks.
     * @return list of blocks.
     */
    @Override
    public List<Block> blocks() {
        this.blocks.add(new Block(385, 150, 30, 30, Color.RED));
        return blocks;
    }

    /**
     * this method returns the number of blocks in this level.
     * @return number of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    /**
     * this method returns the background color of this level.
     * @return background color.
     */
    @Override
    public Color backgroundColor() {
        return Color.black;
    }
}