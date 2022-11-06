package baseball;

import baseball.dto.InputParameters;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputParameters inputParameters = InputView.printStartGame();

        BaseBallGame baseBallGame = new BaseBallGame();
    }
}
