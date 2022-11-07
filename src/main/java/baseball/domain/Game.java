package baseball.domain;

import java.io.IOException;

public interface Game {
/**
 * RandomNumber 생성
 * */
    void startGame(String randomNumber, String input) throws IOException;
    void validate(String input);
    boolean endGame() throws IOException;
}
