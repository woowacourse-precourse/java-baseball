package baseball.domain;

public class BallStatusScore {
    private static final int STRIKE_COUNT_OF_GAME_END_CONDITIONS = 3;
    
    private final int score;
    
    public BallStatusScore() {
        this(0);
    }
    
    public BallStatusScore(final int score) {
        this.score = score;
    }
    
    public BallStatusScore increase() {
        return new BallStatusScore(score + 1);
    }
    
    public boolean isGameEnd() {
        return score == STRIKE_COUNT_OF_GAME_END_CONDITIONS;
    }
}
