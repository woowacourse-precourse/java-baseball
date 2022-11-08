package baseball;

import baseball.domain.BaseBallGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView.printGameStart();

        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.playGame();

        OutputView.printGameEnd();
    }
}
