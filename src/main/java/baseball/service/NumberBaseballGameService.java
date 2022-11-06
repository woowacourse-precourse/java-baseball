package baseball.service;

import baseball.RandomUtil;
import baseball.model.OpponentComputer;

import java.util.Map;

public class NumberBaseballGameService {
    
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
}
