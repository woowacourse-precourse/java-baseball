package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private final Set<Integer> randomNumbers;

    public Computer() {
        randomNumbers = new HashSet<>();
        while (randomNumbers.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }
    }

    public Set<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }
}
