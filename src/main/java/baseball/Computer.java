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

    public Ball compareDigits(List<Integer> inputDigits) {
        Ball ball = new Ball();

        for (int row = 0; row < DIGITS_SIZE; row++) {
            compareDigitsByColumn(inputDigits, ball, row);
        }
        return ball;
    }

    private void compareDigitsByColumn(List<Integer> inputDigits, Ball ball, int row) {
        for (int column = 0; column < DIGITS_SIZE; column++) {
            if (isStrike(inputDigits, row, column)) {
                ball.addStrike();
                return;
            }

            if (isSameDigit(inputDigits.get(row), digits.get(column))) {
                ball.addBall();
                return;
            }
        }
    }

    private boolean isStrike(List<Integer> inputDigits, int row, int column) {
        return isSameDigit(inputDigits.get(row), digits.get(column)) && isSameIndex(row, column);
    }

    private boolean isSameIndex(int row, int column) {
        return row == column;
    }

    private boolean isSameDigit(Integer inputDigit, Integer digit) {
        return inputDigit == digit;
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
