package baseball.controller;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;

public class NumberBaseballGameController {

    private static OpponentComputer opponentComputer;

    public void generateOpponentComputer() {
        opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
    }

    public OpponentComputer getOpponentComputer() {
        return opponentComputer;
    }
}
