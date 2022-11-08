package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 9;
    private final static int MAX_SIZE = 3;

    List<Integer> computerNumber = new ArrayList<>();

    public List<Integer> createComputerNumber() {
        computerNumber = new ArrayList<>();
        while (isMaxSize()) {
            addComputerNumber(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        return computerNumber;
    }

    private boolean isMaxSize() {
        return computerNumber.size() < MAX_SIZE;
    }

    private void addComputerNumber(int number) {
        if (isNotContains(number)) {
            computerNumber.add(number);
        }
    }

    private boolean isNotContains(int number) {
        return !computerNumber.contains(number);
    }
}
