package baseball.model.player;

import baseball.model.number.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    private static final int START_RANDOM_NUMBER_RANGE = 1;
    private static final int END_RANDOM_NUMBER_RANGE = 9;
    private static final int RANDOM_NUMBERS_SIZE = 3;

    private BaseballNumbers computerBaseballNumbers;

    private Integer createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER_RANGE, END_RANDOM_NUMBER_RANGE);
        return randomNumber;
    }

    private void addRandomNumber(List<Integer> randomNumbers, Integer uncheckedNumber) {
        if(isUniqueNumber(randomNumbers, uncheckedNumber)) {
            randomNumbers.add(uncheckedNumber);
        }
    }

    private boolean isUniqueNumber(List<Integer> randomNumbers, Integer uncheckedNumber) {
        if(randomNumbers.contains(uncheckedNumber)) {
            return false;
        }
        return true;
    }
}
