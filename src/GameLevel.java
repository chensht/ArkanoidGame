import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * this class create a game level.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboardSensor;
    private LevelInformation levelInformation;
    private int screenWidth;
    private int screenHeight;

    /**
     * a constructor of game level by a given level information and current score (for game flow).
     * adding it new game environment and new sprite collection.
     * also adding the counters needed.
     * @param animationRunner the animation runner.
     * @param k the keyboard sensor.
     * @param l the level information.
     * @param score the current score.
     */
    public GameLevel(AnimationRunner animationRunner, KeyboardSensor k, LevelInformation l, Counter score) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.remainingBlocks = new Counter(l.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(l.numberOfBalls());
        this.score = score;
        this.runner = animationRunner;
        this.keyboardSensor = k;
        this.levelInformation = l;
        this.screenWidth = 800;
        this.screenHeight = 600;
    }

    /**
     * this method return true if the animation should stop and false otherwise.
     * @return true if the animation should stop, false otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this method draws frame of the animation to a given surface.
     * if the player press the 'p' key, pause screen will appear.
     * @param d the surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            if (this.remainingBlocks.getValue() == 0) {
                this.running = false;
            }
            if (this.remainingBalls.getValue() == 0) {
                this.running = false;
            }
            if (this.keyboardSensor.isPressed("p")) {
                KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new PauseScreen());
                this.runner.run(key);
        }
    }
    /**
     * this method running the animation of the game.
     */

    public void run() {
        this.createBallsAndPaddle();
        this.running = true;
        this.runner.run(this);
    }

    /**
     * this method create the paddle and the balls.
     */
    public void createBallsAndPaddle() {
        Paddle paddle = new Paddle((screenWidth - this.levelInformation.paddleWidth()) / 2, 560,
                this.levelInformation.paddleWidth(), 15, Color.YELLOW, this.keyboardSensor);
        paddle.addToGame(this);
        int index = 0;
        for (Ball b : this.levelInformation.balls()) {
            b.setVelocity(this.levelInformation.initialBallVelocities().get(index));
           b.setGameEnvironment(this.environment);
            b.addToGame(this);
            index++;
        }
    }

    /**
     * this method add a collidable object to the game environment.
     *
     * @param c the collidable object we adding.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * this method remove a collidable object from the game environment.
     *
     * @param c the collidable object we removing.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this method add a sprite object to the sprite collection..
     *
     * @param s the sprite object we adding.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this method remove a sprite object from the sprite collection..
     *
     * @param s the sprite object we removing.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * this method initialize a new game by creating the background, frames and blocks and add them to the game.
     * also activate the listeners and updating the counters accordingly to the game moves.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        Block deathFrame = new Block(0, 595, 800, 5,
                this.levelInformation.backgroundColor());
        deathFrame.addToGame(this);
        deathFrame.addHitListener(ballRemover);
        Block screen = this.levelInformation.getBackground();
        screen.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);
        LevelName levelName = new LevelName(this.levelInformation.levelName());
        levelName.addToGame(this);
        Block topFrame = new Block(0, 25, 800, 25, Color.DARK_GRAY);
        Block leftFrame = new Block(0, 25, 25, 600, Color.DARK_GRAY);
        Block rightFrame = new Block(775, 25, 25, 600, Color.DARK_GRAY);
        Block[] frame = {topFrame, leftFrame, rightFrame};
        for (Block b : frame) {
            b.addToGame(this);
        }
        for (Block b : this.levelInformation.blocks()) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
        }
    }

    /**
     * returns the counter of score.
     * @return the counter of score
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * returns the counter of remaining blocks.
     * @return the counter of remaining blocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
    /**
     * returns the counter of remaining balls.
     * @return the counter of remaining balls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

}