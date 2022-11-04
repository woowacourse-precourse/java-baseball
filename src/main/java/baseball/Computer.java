package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private static final int LENGTH_OF_NUMBER = 3;
    private List<Integer> numbers;

    public List<Integer> selectRandomNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, LENGTH_OF_NUMBER);
        return numbers;
    }


}
