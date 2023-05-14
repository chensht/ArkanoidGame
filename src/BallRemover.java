/**
 * this class represent a ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * a constructor of ball remover that get the game and the number of balls remain.
     * @param game the game we want to remove the ball from.
     * @param remainingBalls the number of balls remain.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * this method removing the ball from the game when an hit happens.
     * @param beingHit the block that the ball hit.
     * @param hitter the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}