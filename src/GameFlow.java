import biuoop.KeyboardSensor;
import java.util.List;

/**
 * this class manage the game and connect between all the levels.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;
    private Boolean isWin;

    /**
     * a constructor of a game flow.
     *
     * @param ar the animation runner.
     * @param ks the KeyboardSensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.isWin = true;
    }

    /**
     * This method runs all the levels given.
     *
     * @param levels the levels given for a running.
     */

    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(this.animationRunner, this.keyboardSensor, levelInfo, this.score);
            level.initialize();
            ScoreIndicator scores = new ScoreIndicator(this.score);
            level.addSprite(scores);
            LevelName name = new LevelName(levelInfo.levelName());
            level.addSprite(name);
            while (level.getRemainingBalls().getValue() > 0 && level.getRemainingBlocks().getValue() > 0) {
                level.run();
            }
            if (level.getRemainingBlocks().getValue() == 0) {
                this.score.increase(100);
                this.isWin = true;
            }
            if (level.getRemainingBalls().getValue() == 0) {
                this.isWin = false;
                break;
            }
        }
        KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY, new EndScreen(this.keyboardSensor, this.isWin, this.score));
        this.animationRunner.run(key);
    }
}