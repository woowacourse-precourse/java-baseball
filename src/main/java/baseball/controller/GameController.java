package baseball.controller;

import baseball.model.NumberBaseBallGame;
import baseball.view.NumberBaseBallView;

import java.util.Map;

public class GameController {
    private final NumberBaseBallGame numberBaseBallGame;
    private final NumberBaseBallView numberBaseBallView;

    public GameController(NumberBaseBallGame numberBaseBallGame, NumberBaseBallView numberBaseBallView) {
        this.numberBaseBallGame = numberBaseBallGame;
        this.numberBaseBallView = numberBaseBallView;
    }

    public void start(){
        numberBaseBallView.start();

        while (numberBaseBallGame.isProceeding()) {
            String inputNumber = numberBaseBallView.askInputNumber();
            numberBaseBallGame.validateInputNumber(inputNumber);

            Map<String, Integer> result = numberBaseBallGame.checkResultPoint(inputNumber);
            numberBaseBallView.printResult(result);

            if (numberBaseBallGame.isFinish(result)) {
                numberBaseBallGame.end();
                String restart = numberBaseBallView.askRestart();
                numberBaseBallGame.restart(restart);
            }
        }
    }
}
