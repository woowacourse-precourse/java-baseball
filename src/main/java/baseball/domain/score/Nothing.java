package baseball.domain.score;

public class Nothing implements Score {
    private static final String UNSUPPORTED_OPERATION_EXCEPTION = "Nothing 상태에서는 지원되지 않는 기능입니다.";
    
    @Override
    public Score increase() {
        throw unsupportedOperationException();
    }
    
    @Override
    public boolean isGameEnd() {
        throw unsupportedOperationException();
    }
    
    @Override
    public int score() {
        throw unsupportedOperationException();
    }
    
    private UnsupportedOperationException unsupportedOperationException() {
        return new UnsupportedOperationException(UNSUPPORTED_OPERATION_EXCEPTION);
    }
}
