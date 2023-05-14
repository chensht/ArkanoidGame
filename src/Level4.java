import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the forth level.
 */
public class Level4 implements LevelInformation {
    private  List<Velocity> velocities;
    private List<Block> blocks;
    private List<Ball> balls;
    private Block background;

    /**
     * a constructor of the forth level.
     */
    public Level4() {
        this.velocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
        this.balls = new ArrayList<Ball>();
        this.background = new Block(0, 0, 800, 600, Color.blue.brighter());
    }

    /**
     * this method returns the number of balls in this level.
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return 3;
    }

    /**
     * this method returns a list of the velocities of the balls.
     * @return list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        this.velocities.add(new Velocity(1, 3));
        this.velocities.add(new Velocity(-1, 3));
        this.velocities.add(new Velocity(0, 4));
        return  this.velocities;
    }

    /**
     * this method returns a list of the balls.
     * @return list of balls.
     */
    @Override
    public List<Ball> balls() {
        this.balls.add(new Ball(350, 400, 5, Color.white));
        this.balls.add(new Ball(450, 400, 5, Color.white));
        this.balls.add(new Ball(400, 375, 5, Color.white));
        return this.balls;
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
        return "Final Four";
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
        double heightOfBlocks = 25;
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 150, widthOfBlocks, heightOfBlocks, Color.DARK_GRAY);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 175, widthOfBlocks, heightOfBlocks, Color.RED);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 200, widthOfBlocks, heightOfBlocks, Color.YELLOW);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 225, widthOfBlocks, heightOfBlocks, Color.GREEN);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 250, widthOfBlocks, heightOfBlocks, Color.PINK);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 275, widthOfBlocks, heightOfBlocks, Color.WHITE);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            double xOfBlock = 775 - widthOfBlocks - (i * widthOfBlocks);
            Block block = new Block(xOfBlock, 300, widthOfBlocks, heightOfBlocks, Color.CYAN);
            this.blocks.add(block);
        }
        return this.blocks;
    }

    /**
     * this method returns the number of blocks in this level.
     * @return number of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

    /**
     * this method returns the background color of this level.
     * @return background color.
     */
    @Override
    public Color backgroundColor() {
        return Color.blue.brighter();
    }
}