package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.Constant.*;

public class Computer {
    private final Set<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = this.generateNumbers();
    }

    public Set<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }

    private Set<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != RANDOM_NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
            numbers.add(randomNumber);
        }
        return numbers;
    }
}
