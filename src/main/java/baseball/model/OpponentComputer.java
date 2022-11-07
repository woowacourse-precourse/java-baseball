package baseball.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpponentComputer {

    private static final String STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY = "Strike";
    private static final String STRIKE_AND_BALL_COUNT_MAP_BALL_KEY = "Ball";
    private static final int STRIKE_AND_BALL_COUNT_MAP_INIT_VALUE = 0;
    private static final String EACH_DIGIT_SPLIT_REGEX = "";

    private int number;
    private final Map<String, Integer> strikeAndBallCountMap = new HashMap<>();

    public OpponentComputer(int randomNumber) {
        this.number = randomNumber;
        initStrikeAndBallCountMap();
    }

    public void initStrikeAndBallCountMap() {
        strikeAndBallCountMap.put(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY, STRIKE_AND_BALL_COUNT_MAP_INIT_VALUE);
        strikeAndBallCountMap.put(STRIKE_AND_BALL_COUNT_MAP_BALL_KEY, STRIKE_AND_BALL_COUNT_MAP_INIT_VALUE);
    }

    public void judgeStrikeOrBallCountOfPlayerNumber(int playerNumber) {
        judgeStrikeOrBall(addEachDigitToList(number), addEachDigitToList(playerNumber));
    }

    public List<String> addEachDigitToList(int number) {
        return Arrays.asList(String.valueOf(number).split(EACH_DIGIT_SPLIT_REGEX));
    }

    public void judgeStrikeOrBall(List<String> opponentComputerNumbers, List<String> playerNumbers) {
        for (int compareEachDigitIndex = 0; compareEachDigitIndex < opponentComputerNumbers.size(); compareEachDigitIndex++) {
            String opponentComputerNumber = opponentComputerNumbers.get(compareEachDigitIndex);
            String playerNumber = playerNumbers.get(compareEachDigitIndex);
            if (opponentComputerNumber.equals(playerNumber)) {
                strikeAndBallCountMap.put(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY, strikeAndBallCountMap.get(STRIKE_AND_BALL_COUNT_MAP_STRIKE_KEY) + 1);
            }
            if (opponentComputerNumbers.contains(playerNumber) && !opponentComputerNumber.equals(playerNumber)) {
                strikeAndBallCountMap.put(STRIKE_AND_BALL_COUNT_MAP_BALL_KEY, strikeAndBallCountMap.get(STRIKE_AND_BALL_COUNT_MAP_BALL_KEY) + 1);
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public Map<String, Integer> getStrikeAndBallCountMap() {
        return strikeAndBallCountMap;
    }
}
