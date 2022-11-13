package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 9;
    private static final int INIT_LIST_SIZE = 3;
    private static final List<Integer> numbers = new ArrayList<>(INIT_LIST_SIZE);

    public void initNumbers() {
        numbers.clear();
        while (numbers.size() < INIT_LIST_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
            addNumber(randomNumber);
        }
    }

    private void addNumber(int number) {
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
