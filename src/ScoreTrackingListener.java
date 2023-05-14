/**
 * This class represents a score tracking listener object.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * a constructor of score tracking listener object by a score counter.
     * @param scoreCounter the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * when a hit happens. this method updating the score accordingly (5 points for every block being hit).
     * @param beingHit the object (block) being hit by the hitter ball.
     * @param hitter the hitter object (the ball that's doing the hitting).
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

}
