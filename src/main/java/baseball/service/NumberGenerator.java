package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final int PICK_MAX_COUNT = 3;

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(PICK_MAX_COUNT);
        int pickCount = 0;

        while (pickCount < PICK_MAX_COUNT) {
            randomNumbers.add(pickUniqueNumber(randomNumbers));
            pickCount++;
        }

        return randomNumbers;
    }

    private int pickUniqueNumber(List<Integer> randomNumbers) {
        int pickNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);

        while (randomNumbers.contains(pickNumber)) {
            pickNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
        }

        return pickNumber;
    }
}