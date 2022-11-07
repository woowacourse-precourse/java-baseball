package baseball.domain;


import baseball.view.BaseBallInput;
import baseball.view.UserInput;

import java.io.IOException;

public abstract class GameCreator {
    public abstract void createGame() throws IOException;
}
