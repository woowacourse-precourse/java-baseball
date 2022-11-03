package baseball.controller;

import baseball.model.NumberBaseBallGame;
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
        }
    }
}
