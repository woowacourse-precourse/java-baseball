package baseball.controller;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGameController {

    private static OpponentComputer opponentComputer;

    public void generateOpponentComputer() {
        opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
    }

    public void gameStart() {
        OutputView.printGameStartMessage();
    }

    public void gamePlay() {
        while(opponentComputer.getStrikeAndBallCountMap().get("Strike") != 3) {
            String playerNumber = InputView.inputNumber();
            opponentComputer.initStrikeAndBallCountMap();
            opponentComputer.judgeStrikeOrBallCountOfPlayerNumber(Integer.parseInt(playerNumber));
            Integer strikeCount = opponentComputer.getStrikeAndBallCountMap().get("Strike");
            Integer ballCount = opponentComputer.getStrikeAndBallCountMap().get("Ball");
            OutputView.printGameResultMessage(strikeCount, ballCount);
        }
    }
    
    public OpponentComputer getOpponentComputer() {
        return opponentComputer;
    }
}
