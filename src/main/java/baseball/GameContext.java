package baseball;

import baseball.logic.GameLogic;
import baseball.screen.OutputResolver;

public class GameContext {
    public Game game() {
        return new Game(gameLogic(), outputResolver());
    }

    public GameLogic gameLogic() {
        return new GameLogic();
    }

    public OutputResolver outputResolver() {
        return new OutputResolver();
    }
}
