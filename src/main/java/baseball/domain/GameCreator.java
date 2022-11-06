package baseball.domain;


import baseball.view.BaseBallInput;
import baseball.view.UserInput;

import java.io.IOException;

public abstract class GameCreator {
    public abstract Game createGame() throws IOException;

    void startGame() {
        Game game = createGame();
        UserInput input = new BaseBallInput();
        game.validate(input);
        game.startGame(input);

    }
}
