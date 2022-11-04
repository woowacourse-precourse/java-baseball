package baseball.domain.score;

public interface Score {
    int STRIKE_COUNT_OF_GAME_END_CONDITIONS = 3;
    
    Score increase();
    
    boolean isGameEnd();
    
    int score();
}
