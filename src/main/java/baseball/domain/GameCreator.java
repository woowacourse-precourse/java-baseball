package baseball.domain;


import baseball.view.BaseBallInput;
import baseball.view.UserInput;

import java.io.IOException;

public abstract class GameCreator {
    public abstract Game createGame() throws IOException;

    void startGame() throws IOException {
        Game game = createGame();
        game.startGame();
        UserInput userInput = new BaseBallInput();
    }
}
