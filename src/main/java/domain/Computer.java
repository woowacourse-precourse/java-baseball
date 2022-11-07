package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers = new ArrayList<>();
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    public void createRandomNumbers() {
        for (int i = 0; i < COUNT; i++) {
            numbers.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void init() {
        this.numbers = new ArrayList<>();
    }

}
