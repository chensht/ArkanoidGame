import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the second level.
 */
public class Level2 implements LevelInformation {
    private  List<Velocity> velocities;
    private List<Block> blocks;
    private List<Ball> balls;
    private Block background;

    /**
     * a constructor of the second level.
     */
    public Level2() {
        this.velocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
        this.balls = new ArrayList<Ball>();
        this.background = new Block(0, 0, 800, 600, Color.white);
    }

    /**
     * this method returns the number of balls in this level.
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * this method returns a list of the velocities of the balls.
     * @return list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls(); i++) {
            this.velocities.add(new Velocity(1, 4));
        }
        return this.velocities;
    }

    /**
     * this method returns a list of the balls.
     * @return list of balls.
     */
    @Override
    public List<Ball> balls() {
        this.balls.add(new Ball(200, 380, 5, Color.black));
        this.balls.add(new Ball(240, 345, 5, Color.black));
        this.balls.add(new Ball(280, 317, 5, Color.black));
        this.balls.add(new Ball(320, 295, 5, Color.black));
        this.balls.add(new Ball(360, 280, 5, Color.black));
        this.balls.add(new Ball(440, 280, 5, Color.black));
        this.balls.add(new Ball(480, 295, 5, Color.black));
        this.balls.add(new Ball(520, 317, 5, Color.black));
        this.balls.add(new Ball(560, 345, 5, Color.black));
        this.balls.add(new Ball(600, 380, 5, Color.black));
        return this.balls;
    }

    /**
     * this method returns the paddle width.
     * @return paddle width.
     */
    @Override
    public int paddleWidth() {
        return 600;
    }

    /**
     * this method returns the level name.
     * @return level name.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
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
        double widthOfBlocks = 50;
        double heightOfBlocks = 20;
        int i = 0;
        for (; i < 2; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.RED);
            this.blocks.add(block);
        }
        for (; i < 4; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.ORANGE);
            this.blocks.add(block);
        }
        for (; i < 6; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.YELLOW);
            this.blocks.add(block);
        }
        for (; i < 9; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.GREEN);
            this.blocks.add(block);
        }
        for (; i < 11; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.BLUE);
            this.blocks.add(block);
        }
        for (; i < 13; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.PINK);
            this.blocks.add(block);
        }
        for (; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.CYAN);
            this.blocks.add(block);
        }
        return  this.blocks;
    }

    /**
     * this method returns the number of blocks in this level.
     * @return number of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

    /**
     * this method returns the background color of this level.
     * @return background color.
     */
    @Override
    public Color backgroundColor() {
        return Color.white;
    }
}