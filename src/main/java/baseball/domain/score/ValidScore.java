package baseball.domain.score;

public abstract class ValidScore implements Score {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "스코어는 0~3의 범위를 벗어날 수 없습니다.";
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 3;
    
    private final int score;
    
    ValidScore(final int score) {
        validateOutOfRange(score);
        this.score = score;
    }
    
    private void validateOutOfRange(final int score) {
        if (isScoreOutOfRange(score)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private boolean isScoreOutOfRange(final int score) {
        return score < MIN_SCORE || score > MAX_SCORE;
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
