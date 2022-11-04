package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int RANDOM_NUMBERS_SIZE = 3;

    private final List<Integer> randomNumbers;

    public Computer() {
        randomNumbers = new ArrayList<>();
    }

    public void generateUniqueRandomNumbers() {
        randomNumbers.clear();
        while (randomNumbers.size() < RANDOM_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
