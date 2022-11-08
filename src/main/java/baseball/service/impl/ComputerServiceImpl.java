package baseball.service.impl;

import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerServiceImpl implements ComputerService {

    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 9;
    private final static int MAX_SIZE = 3;

    List<Integer> numbers = new ArrayList<>();

    public List<Integer> createComputerNumber() {
        clearNumbers();
        while (isMaxSize()) {
            addComputerNumber(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        return numbers;
    }

    private void clearNumbers() {
        numbers = new ArrayList<>();
    }

    private boolean isMaxSize() {
        return numbers.size() < MAX_SIZE;
    }

    private void addComputerNumber(int number) {
        if (isNotContains(number)) {
            numbers.add(number);
        }
    }

    private boolean isNotContains(int number) {
        return !numbers.contains(number);
    }
}
