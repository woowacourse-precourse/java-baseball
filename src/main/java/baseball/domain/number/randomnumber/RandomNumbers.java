package baseball.domain.number.randomnumber;

import baseball.domain.number.SingleNumber;

import java.util.Collections;
import java.util.List;

public class RandomNumbers {

    private final List<SingleNumber> randomNumbers;

    RandomNumbers(List<SingleNumber> randomNumber) {
        this.randomNumbers = randomNumber;
    }

    public List<SingleNumber> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
