package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int DIGIT_NUM = 3;
    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 9;

    public List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < DIGIT_NUM) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
            if (!(computer.contains(randomNumber))) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
