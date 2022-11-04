package baseball.domain.score;

public abstract class AbstractScore implements Score {
    private final int score;
    
    AbstractScore(final int score) {
        this.score = score;
    }
    
    @Override
    public int score() {
        return score;
    }
    
    @Override
    public String toString() {
        return "AbstractScore{" +
                "score=" + score +
                '}';
    }
}
