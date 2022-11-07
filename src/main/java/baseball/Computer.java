package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_DIGIT = 3;

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
        randomNumbers = new ArrayList<>(NUMBER_DIGIT);

        while (randomNumbers.size() < NUMBER_DIGIT) {
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
