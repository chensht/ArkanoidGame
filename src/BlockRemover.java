/**
 * this class represent a block remover.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * a constructor of block remover that get the game and the number of blocks remain.
     * @param game the game we want to remove the block from.
     * @param remainingBlocks the number of blocks remain.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * this method removing the block from the game when an hit happens.
     * also removing the block from the listener list.
     * @param beingHit the block that the ball hit.
     * @param hitter the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}