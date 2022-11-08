package baseball;

import baseball.model.BaseBallGame;
import baseball.model.HomeRunStrategy;


public class Application {
    public static void main(String[] args) {
        HomeRunStrategy homeRunStrategy = new HomeRunStrategy();
        BaseBallGame baseBallGame = new BaseBallGame();
        GameFrame gameFrame = new GameFrame(baseBallGame);

        gameFrame.startGuide();
        gameFrame.start(homeRunStrategy.createBallNumbers());
    }
}
