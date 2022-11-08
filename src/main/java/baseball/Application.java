package baseball;

import baseball.controller.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }
}
