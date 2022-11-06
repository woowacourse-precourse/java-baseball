package baseball;

import java.util.*;
import java.util.stream.Stream;

public class GameHost extends BaseballNumber {
    private Map<String, Integer> hint = new HashMap<>();

    @Override
    public boolean isValidBaseballNumber(List<Integer> baseballNumber) {
        boolean checkNumberLength = super.isBaseballNumberLength3(baseballNumber);
        boolean checkDuplicateNum = super.isNotDuplicatedNumber(baseballNumber);
        boolean checkRangeNum = super.isValidRange(baseballNumber);

        return checkRangeNum && checkDuplicateNum && checkNumberLength;
    }

    public String getHint(List<Integer> playerNumber) {
        return "";
    }

    public void setHint(List<Integer> playerNumber) {
    }
}
