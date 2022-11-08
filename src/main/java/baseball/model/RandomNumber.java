package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public List<Integer> createNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);

            if (!randomNumbers.contains(randomNumber))
                randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
}
