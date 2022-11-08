package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.ConstValue.MAX_RANGE_NUMBER;
import static baseball.ConstValue.MIN_RANGE_NUMBER;
import static baseball.ConstValue.NUMBERS_LENGTH;

public class Computer {

    private void putNumber(List<Integer> numbers) {
        Score score = new Score();
        score.computerNumbers(numbers);
    }

    public void pickRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            if (! randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        putNumber(randomNumbers);
    }
}
