package baseball.domain;

import baseball.view.UserInput;

public interface Game {
/**
 * RandomNumber 생성
 * */
    void startGame(UserInput input);
    void endGame();
}
