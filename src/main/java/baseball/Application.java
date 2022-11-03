package baseball;

import baseball.baseballgame.BaseBallGame;
import baseball.inputview.InputView;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
        if (InputView.ask_restart()) {
            baseBallGame = new BaseBallGame();
            baseBallGame.start();
        }
    }
}
