package baseball.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.exception.*;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int DIGITS = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int DUP_COUNT = 1;

    public int inputGameOption() {
        try {
            String playerInputNumbers = Console.readLine();
            return Integer.parseInt(playerInputNumbers);
        } catch (NumberFormatException e) {
            throw new InputOutOfOptionException();
        }
    }

    public List<Integer> inputNumbers() {
        try {
            String numbers = Console.readLine();
            List<Integer> numberList = new ArrayList<>();

            for (char number : numbers.toCharArray()) {
                numberList.add(Integer.parseInt(Character.toString(number)));
            }

            validateInputNumbers(numberList);

            return numberList;
        } catch (NumberFormatException e) {
            throw new InputNumberNotIntegerException();
        }
    }

    private void validateInputNumbers(List<Integer> numberList) {
        validateInputNumbersOutOfRange(numberList);
        validateNumberMatchDigit(numberList);
        validateNumberDuplicate(numberList);
    }

    private void validateInputNumbersOutOfRange(List<Integer> numberList) {
        if (isInputNumbersOutOfRange(numberList)) {
            throw new InputOutOfRangeException();
        }
    }

    private boolean isInputNumbersOutOfRange(List<Integer> numberList) {
        return numberList.stream().anyMatch(this::isInputNumberOutOfRange);
    }

    private boolean isInputNumberOutOfRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }

    private void validateNumberMatchDigit(List<Integer> numberList) {
        if (!isMatchDigit(numberList)) {
            throw new InputNumberNotMatchException();
        }
    }

    private boolean isMatchDigit(List<Integer> numberList) {
        return numberList.size() == DIGITS;
    }

    private void validateNumberDuplicate(List<Integer> numberList) {
        if (isDuplicate(numberList)) {
            throw new InputNumberDuplicateException();
        }
    }

    private boolean isDuplicate(List<Integer> numberList) {
        return numberList.stream().anyMatch(number -> Collections.frequency(numberList, number) > DUP_COUNT);
    }
}
