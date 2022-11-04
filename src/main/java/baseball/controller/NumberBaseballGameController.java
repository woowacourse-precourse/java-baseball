package baseball.controller;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;
import baseball.view.OutputView;

public class NumberBaseballGameController {

    private static OpponentComputer opponentComputer;

    public void generateOpponentComputer() {
        opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
    }

    public void gameStart() {
        OutputView.printGameStartMessage();
    }
    
    public OpponentComputer getOpponentComputer() {
        return opponentComputer;
    }
}
