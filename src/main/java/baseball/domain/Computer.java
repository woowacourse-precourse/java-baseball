package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final int RANDOM_NUMBERS_LENGTH = 3;
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
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
