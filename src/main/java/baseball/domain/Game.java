package baseball.domain;

import baseball.view.UserInput;

import java.io.IOException;

public interface Game {
/**
 * RandomNumber 생성
 * */
    void startGame() throws IOException;
    void validate(String input);
    void endGame();
}
