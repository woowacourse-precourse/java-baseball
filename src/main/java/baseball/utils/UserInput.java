package baseball.utils;

import static baseball.BaseBallGame.GAME_EXIT;
import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;
import static baseball.BaseBallGame.GAME_RESTART;

import java.util.HashSet;
import java.util.Set;

public class UserInput {

    private static final Integer INPUT_LOWER_BOUND = 123;
    private static final Integer INPUT_UPPER_BOUND = 987;

    private InputReader inputReader;

    public UserInput(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public boolean isContinue() {
        if (GAME_RESTART.equals(getOptionInput())) {
            return true;
        }
        return false;
    }

    private Integer getOptionInput() {
        Integer input = getValidInput();
        if (GAME_RESTART.equals(input) || GAME_EXIT.equals(input)) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public Integer[] getGameInput() {
        Integer input = getValidInput();
        checkLengthThree(input);
        Integer[] inputArray = integerToIntegerArray(input);
        checkDigitValidation(inputArray);

        return inputArray;
    }

    private Integer getValidInput() {
        return getIntegerFromString(inputReader.getInput());
    }

    private Integer getIntegerFromString(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 3 길이체크
    private void checkLengthThree(Integer input) {
        if (INPUT_LOWER_BOUND <= input && input <= INPUT_UPPER_BOUND) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private Integer[] integerToIntegerArray(Integer input) {
        Integer[] inputArray = new Integer[GAME_NUMBER_LENGTH];
        int idx = GAME_NUMBER_LENGTH - 1;
        int operand = 10;
        while (input > 0) {
            inputArray[idx--] = input % operand;
            input = input / operand;
        }
        return inputArray;
    }

    private void checkDigitValidation(final Integer[] inputArray) {
        Set<Integer> uniqueDigits = new HashSet<>();
        for (Integer input : inputArray) {
            checkIfZero(input);
            uniqueDigits.add(input);
        }
        if (uniqueDigits.size() < GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIfZero(Integer input) {
        if (input.equals(0)) {
            throw new IllegalArgumentException();
        }
    }
}
