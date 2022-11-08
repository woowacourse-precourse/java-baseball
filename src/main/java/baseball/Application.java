package baseball;

import baseball.controller.BasicBaseballGame;
import baseball.controller.GameContext;

public class Application {
    public static void main(String[] args) {
        GameContext gameContext = new GameContext(new BasicBaseballGame());
        gameContext.runGameMain();
    }
}
