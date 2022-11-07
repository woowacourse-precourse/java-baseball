package baseball.model.player;

import static baseball.model.Constant.END_RANDOM_NUMBER_RANGE;
import static baseball.model.Constant.RANDOM_NUMBERS_SIZE;
import static baseball.model.Constant.START_RANDOM_NUMBER_RANGE;

import baseball.model.hint.Hint;
import baseball.model.number.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private BaseballNumbers computerBaseballNumbers;

    public void createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < RANDOM_NUMBERS_SIZE) {
            Integer randomNumber = createRandomNumber();
            addRandomNumber(randomNumbers, randomNumber);
        }
        this.computerBaseballNumbers = new BaseballNumbers(randomNumbers);
    }

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

    public Hint makeUserInputHint(BaseballNumbers userBaseballNumbers) {
        Hint userInputHint = new Hint(computerBaseballNumbers, userBaseballNumbers);
        return userInputHint;
    }
}
