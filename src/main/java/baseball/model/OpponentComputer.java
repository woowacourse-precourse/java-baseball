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
        strikeAndBallCountMap.put("Strike", 0);
        strikeAndBallCountMap.put("Ball", 0);
    }
    public List<String> addEachDigitToList(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }

    public int getNumber() {
        return number;
    }

    public Map<String, Integer> getStrikeAndBallCountMap() {
        return strikeAndBallCountMap;
    }
}
