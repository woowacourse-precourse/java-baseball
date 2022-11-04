package baseball.domain.score;

public class StrikeScore extends AbstractScore  {
    public StrikeScore() {
        this(0);
    }
    
    public StrikeScore(final int score) {
        super(score);
    }
    
    @Override
    public Score increase() {
        return new StrikeScore(score() + 1);
    }
    
    @Override
    public boolean isGameEnd() {
        return score() == STRIKE_COUNT_OF_GAME_END_CONDITIONS;
    }
}
