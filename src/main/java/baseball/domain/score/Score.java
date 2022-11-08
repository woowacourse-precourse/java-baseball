package baseball.domain.score;

public interface Score {
    Score increase();
    
    boolean isGameEnd();
    
    int score();
}
