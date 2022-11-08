package baseball;

import baseball.model.BaseBallGame;
import baseball.model.HomeRunStrategy;


public class Application {
    public static void main(String[] args) {
        HomeRunStrategy homeRunStrategy = new HomeRunStrategy();
        BaseBallGame baseBallGame = new BaseBallGame();
        GameFrame gameFrame = new GameFrame();

        gameFrame.startGuide();
        gameFrame.start(baseBallGame, homeRunStrategy.createBallNumbers());
    }
}
