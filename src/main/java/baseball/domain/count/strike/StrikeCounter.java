package baseball.domain.count.strike;

import baseball.domain.number.SingleNumber;
import baseball.domain.number.inputnumber.InputNumbers;

import java.util.List;

public class StrikeCounter {

    public int checkStrike(List<SingleNumber> randomNumbers, InputNumbers inputNumbers) {
        return inputNumbers.countStrike(randomNumbers);
    }
}
