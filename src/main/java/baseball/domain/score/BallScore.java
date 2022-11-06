package baseball.domain.score;

public class BallScore extends ValidScore {
    public static final String UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE = "BALL 의 개수는 게임 종료의 조건이 되지 않습니다.";
    
    public BallScore() {
        this(0);
    }
    
    public BallScore(final int score) {
        super(score);
    }
    
    @Override
    public Score increase() {
        return new BallScore(score() + 1);
    }
    
    @Override
    public boolean isGameEnd() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION_MESSAGE);
    }
}
