package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    public void createRandomNumbers() {
        this.numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void init() {
        this.numbers = new ArrayList<>();
    }

}
