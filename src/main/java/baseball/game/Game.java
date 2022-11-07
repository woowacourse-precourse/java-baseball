package baseball.game;

public interface Game {
    void start();

    boolean isRestart();

    void showStartMessage();

    void showEndMessage();
}
