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

    public void setBaseballNumber() {
        this.baseballNumber = new ArrayList<>();
        int[] checkValidNumber = new int[10];
        Random random = new Random();

        while(this.baseballNumber.size() != 3) {
            int randomNum = random.nextInt(9) + 1;
            if(checkValidNumber[randomNum] == 0) {
                this.baseballNumber.add(randomNum);
                checkValidNumber[randomNum] = 1;
            }
        }
    }
}
