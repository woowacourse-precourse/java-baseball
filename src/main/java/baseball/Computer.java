package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private static final int DIGITS_SIZE = 3;

    private List<Integer> digits = new ArrayList<>();

    public Computer() {
        generateRandomNumber();
    }

    public List<Integer> getDigits() {
        return digits;
    }

    private void generateRandomNumber() {
        while (isValidRange()) {
            addNumber(Randoms.pickNumberInRange(RANGE_START, RANGE_END));
        }
    }

    private boolean isValidRange() {
        return digits.size() != DIGITS_SIZE;
    }

    private void addNumber(int pickNumber) {
        if (isUnique(pickNumber)) {
            digits.add(pickNumber);
        }
    }

    private boolean isUnique(int pickNumber) {
        return !digits.contains(pickNumber);
    }
}
