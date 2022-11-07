package baseball.domain;

import static baseball.global.constants.Constants.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    private Computer() {

    }

    public static Computer of() {
        return new Computer();
    }

    public void init() {
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        randomNumbers = new ArrayList<>(THREE_DIGITS);

        while (randomNumbers.size() < THREE_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
