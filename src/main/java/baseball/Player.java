package baseball;

import java.util.List;
import utils.InputUtils;

public class Player extends BaseballNumber {
    public List<Integer> isValidBaseballNumber(String playerInput) {
        boolean checkNumberLength = InputUtils.isBaseballNumberLength3(playerInput);
        boolean checkDuplicateNum = InputUtils.isNotDuplicatedNumber(playerInput);
        boolean checkRangeNum = InputUtils.isValidRange(playerInput);

        if(!checkRangeNum || !checkDuplicateNum || !checkNumberLength) {
            throw new IllegalArgumentException();
        }
        return InputUtils.changeStringInputToList(playerInput);
    }
}
