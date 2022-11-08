package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private static final int DIGIT_NUM = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < DIGIT_NUM) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!(computer.contains(randomNumber))) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
