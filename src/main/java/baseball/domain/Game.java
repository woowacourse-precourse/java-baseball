package baseball.domain;

import java.io.IOException;

public interface Game {
    void startGame(String randomNumber, String input) throws IOException;
    boolean endGame() throws IOException;

    void validate(String input);
}
