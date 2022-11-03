package baseball.controller;

import baseball.model.NumberBaseBallGame;
import baseball.model.Result;
import baseball.view.NumberBaseBallView;

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

            Result result = numberBaseBallGame.result(inputNumber);
            numberBaseBallView.printResult(result);
            if (result.isFinish()) {
                numberBaseBallGame.end();
                String restart = numberBaseBallView.askRestart();
                numberBaseBallGame.restart(restart);
            }
        }
    }
}
