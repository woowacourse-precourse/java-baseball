package baseball.controller;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGameController {

    private static final String STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY = "Strike";
    private static final String STRIKE_AND_BALL_COUNT_MAP_BALL_KEY = "Ball";
    private static final int THREE_STRIKE_COUNT = 3;
    private static final String GAME_RESTART_NUMBER = "1";


    private static OpponentComputer opponentComputer;

    public void generateOpponentComputer() {
        opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
    }

    public void gameStart() {
        OutputView.printGameStartMessage();
    }

    public void gamePlay() {
        while(opponentComputer.getStrikeAndBallCountMap().get(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY) != THREE_STRIKE_COUNT) {
            String playerNumber = InputView.inputNumber();
            opponentComputer.initStrikeAndBallCountMap();
            opponentComputer.judgeStrikeOrBallCountOfPlayerNumber(Integer.parseInt(playerNumber));
            Integer strikeCount = opponentComputer.getStrikeAndBallCountMap().get(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY);
            Integer ballCount = opponentComputer.getStrikeAndBallCountMap().get(STRIKE_AND_BALL_COUNT_MAP_BALL_KEY);
            OutputView.printGameResultMessage(strikeCount, ballCount);
        }
    }

    public void gameRestartOrEnd() {
        String restartOrEndNumber = InputView.inputRestartOrEndNumber();
        if (restartOrEndNumber.equals(GAME_RESTART_NUMBER)) {
            generateOpponentComputer();
            gamePlay();
        }
    }

    public OpponentComputer getOpponentComputer() {
        return opponentComputer;
    }
}
