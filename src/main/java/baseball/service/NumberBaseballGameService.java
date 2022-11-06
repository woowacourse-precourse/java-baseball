package baseball.service;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;

import java.util.Map;

public class NumberBaseballGameService {

    private static final String STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY = "Strike";

    private static OpponentComputer opponentComputer;

    public void generateOpponentComputer() {
        opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
    }

    public OpponentComputer getOpponentComputer() {
        return opponentComputer;
    }

    public Map<String, Integer> judgeStrikeOrBallCount(String playerNumber) {
        opponentComputer.initStrikeAndBallCountMap();
        opponentComputer.judgeStrikeOrBallCountOfPlayerNumber(Integer.parseInt(playerNumber));
        return opponentComputer.getStrikeAndBallCountMap();
    }

    public int getStrikeCount() {
        return opponentComputer.getStrikeAndBallCountMap().get(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY);
    }
}
