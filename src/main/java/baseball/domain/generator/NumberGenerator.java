package baseball.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int SIZE_INDEX = 3;
    private static final int START_INDEX = 1;
    private static final int END_INDEX = 9;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < SIZE_INDEX) {
            int randomNumber = Randoms.pickNumberInRange(START_INDEX, END_INDEX);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}