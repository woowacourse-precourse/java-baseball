package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int DIGITS_SIZE = 3;
    private static final char ZERO = '0';

    public User() {
    }

    public List<Integer> input() {
        char[] input = getDigits();
        List<Integer> digits = new ArrayList<>();

        validateLength(input);
        validateDigit(input);
        validateSameDigit(input);
        convertToInt(input, digits);
        return digits;
    }

    private void validateSameDigit(char[] input) {
        for (int row = 0; row < DIGITS_SIZE - 1; row++) {
            validateSameDigitByColumn(input, row);
        }
    }

    private void validateSameDigitByColumn(char[] input, int row) {
        for (int column = row + 1; column < DIGITS_SIZE; column++) {
            checkSameDigit(input, row, column);
        }
    }

    private void checkSameDigit(char[] input, int row, int column) {
        if (isSameDigit(input[row], input[column])) {
            throw new IllegalArgumentException("동일한 수를 입력할 수 없습니다.");
        }
    }

    private boolean isSameDigit(char rowCharacter, char columnCharacter) {
        return rowCharacter == columnCharacter;
    }

    private void convertToInt(char[] input, List<Integer> digits) {
        for (int index = 0; index < DIGITS_SIZE; index++) {
            digits.add(toInt(input[index]));
        }
    }

    private int toInt(char input) {
        return input - ZERO;
    }

    private void validateDigit(char[] digits) {
        for (int index = 0; index < DIGITS_SIZE; index++) {
            checkDigit(digits, index);
        }
    }

    private void checkDigit(char[] digits, int index) {
        if (isWrong(digits[index])) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private boolean isWrong(char digit) {
        return !Character.isDigit(digit) || digit == ZERO;
    }

    private void validateLength(char[] input) {
        if (input.length != DIGITS_SIZE) {
            throw new IllegalArgumentException("세 자리를 입력해 주세요.");
        }
    }

    private char[] getDigits() {
        return inputData().toCharArray();
    }

    private String inputData() {
        return Console.readLine();
    }

}