package baseball.user;

import static baseball.BaseBallGame.GAME_EXIT;
import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;
import static baseball.BaseBallGame.GAME_RESTART;

import baseball.user.pitcher.Pitcher;
import baseball.user.util.InputReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInput implements Pitcher, OptionSelector {

    private static final Integer INPUT_LOWER_BOUND = 123;
    private static final Integer INPUT_UPPER_BOUND = 987;
    private static final Integer OPERAND = 100;
    private static final Integer RADIX_DECIMAL = 10;
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
    public List<Integer> pitching() {
        Integer input = getValidInput();
        checkLengthThree(input);
        List<Integer> inputList = integerToIntegerList(input);
        checkDigitValidation(inputList);
        return inputList;
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

    private List<Integer> integerToIntegerList(Integer input) {
        List<Integer> inputList = new ArrayList<>();
        int operand = OPERAND;
        while (operand > 0) {
            inputList.add(input / operand);
            input = input % operand;
            operand = operand / RADIX_DECIMAL;
        }
        return inputList;
    }

    private void checkDigitValidation(final List<Integer> inputList) {
        checkUniqueDigitRule(inputList);
        checkNonZeroDigitRule(inputList);
    }

    private void checkUniqueDigitRule(final List<Integer> inputList) {
        Set<Integer> uniqueDigits = new HashSet<>(inputList);
        if (uniqueDigits.size() < GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNonZeroDigitRule(final List<Integer> inputList) {
        for (Integer input : inputList) {
            checkIfZero(input);
        }
    }

    private void checkIfZero(Integer input) {
        if (input.equals(0)) {
            throw new IllegalArgumentException();
        }
    }
}
