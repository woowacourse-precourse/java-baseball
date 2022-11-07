
package baseball.view;

import baseball.exception.InputDuplicateException;
import baseball.exception.InputNotMatchDigitException;
import baseball.exception.InputNotNumberException;
import baseball.exception.InputOutOfRangeException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.rule.Digit.isMatchDigit;

public class InputView {

    private static final int FIRST = 1;
    private static final int DUP_LIMIT_COUNT = 1;
    private static final int LAST = 9;

    public int inputNumber() {
        try {
            String number = Console.readLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    public List<Integer> inputNumbers() {
        try {
            String inputItems = Console.readLine();
            List<Integer> numbers = new ArrayList<>();

            for (char item : inputItems.toCharArray()) {
                numbers.add(Integer.parseInt(Character.toString(item)));
            }

            validateNumbers(numbers);

            return numbers;
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    private void validateNumbers(List<Integer> inputs) {
        validateInputDuplicate(inputs);
        validateInputMatchDigit(inputs);
        validateInputOutOfRange(inputs);
    }

    private void validateInputDuplicate(List<Integer> inputs) {
        if (isDuplicate(inputs)) {
            throw new InputDuplicateException();
        }
    }

    private boolean isDuplicate(List<Integer> inputs) {
        return inputs.stream().anyMatch(input -> Collections.frequency(inputs, input) > DUP_LIMIT_COUNT);
    }

    private void validateInputMatchDigit(List<Integer> inputs) {
        if (!isMatchDigit(inputs)) {
            throw new InputNotMatchDigitException();
        }
    }

    private void validateInputOutOfRange(List<Integer> inputs) {
        if (isInputsOutOfRange(inputs)) {
            throw new InputOutOfRangeException();
        }
    }

    private boolean isInputsOutOfRange(List<Integer> inputs) {
        return inputs.stream().anyMatch(this::isInputOutOfRange);
    }

    private boolean isInputOutOfRange(int input) {
        return input > LAST || input < FIRST;
    }
}