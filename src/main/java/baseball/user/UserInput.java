package baseball.user;

import static baseball.BaseBallGame.GAME_EXIT;
import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;
import static baseball.BaseBallGame.GAME_RESTART;

import baseball.user.pitcher.Pitcher;
import baseball.user.util.InputReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInput implements Pitcher, OptionSelector {

    private static final Integer INPUT_LOWER_BOUND = 123;
    private static final Integer INPUT_UPPER_BOUND = 987;

    private final InputReader inputReader;

    public UserInput(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public boolean isContinue() {
        return GAME_RESTART.equals(getOptionInput());
    }

    private Integer getOptionInput() {
        Integer input = getValidInput();
        if (GAME_RESTART.equals(input) || GAME_EXIT.equals(input)) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Integer[] pitching() {
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
        checkUniqueDigitRule(inputArray);
        checkNonZeroDigitRule(inputArray);
    }

    private void checkUniqueDigitRule(final Integer[] inputArray) {
        Set<Integer> uniqueDigits = new HashSet<>(Arrays.asList(inputArray));
        if (uniqueDigits.size() < GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNonZeroDigitRule(final Integer[] inputArray) {
        for (Integer input : inputArray) {
            checkIfZero(input);
        }
    }

    private void checkIfZero(Integer input) {
        if (input.equals(0)) {
            throw new IllegalArgumentException();
        }
    }
}
