package baseball.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpponentComputer {

    private int number;
    private final Map<String, Integer> strikeAndBallCountMap = new HashMap<>();

    public OpponentComputer(int randomNumber) {
        this.number = randomNumber;
        initStrikeAndBallCountMap();
    }

    public void initStrikeAndBallCountMap() {
        strikeAndBallCountMap.put("Strike", 0);
        strikeAndBallCountMap.put("Ball", 0);
    }

    public void judgeStrikeOrBallCountOfPlayerNumber(int playerNumber) {
        judgeStrikeOrBall(addEachDigitToList(number), addEachDigitToList(playerNumber));
    }

    public List<String> addEachDigitToList(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }

    public void judgeStrikeOrBall(List<String> opponentComputerNumbers, List<String> playerNumbers) {
        for (int compareEachDigitIndex = 0; compareEachDigitIndex < opponentComputerNumbers.size(); compareEachDigitIndex++) {
            String opponentComputerNumber = opponentComputerNumbers.get(compareEachDigitIndex);
            String playerNumber = playerNumbers.get(compareEachDigitIndex);
            if (opponentComputerNumber.equals(playerNumber)) {
                strikeAndBallCountMap.put("Strike", strikeAndBallCountMap.get("Strike") + 1);
            }
            if (opponentComputerNumbers.contains(playerNumber) && !opponentComputerNumber.equals(playerNumber)) {
                strikeAndBallCountMap.put("Ball", strikeAndBallCountMap.get("Ball") + 1);
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
