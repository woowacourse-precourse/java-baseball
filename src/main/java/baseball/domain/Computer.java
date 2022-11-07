package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

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
        while (randomNumbers.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }
        return numbers;
    }
}
