package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    private static final String IS_OUT_OF_RANGE_MESSAGE = "You must enter a number between 1 and 9.";
    private static final String IS_SUITABLE_LENGTH_MESSAGE = "enter a three-digit number.";
    private static final String IS_DUPLICATED_MESSAGE = "The number is duplicated.";
    private static final String RESTART_BASEBALL_GAME = "1";
    private static final String QUIT_BASEBALL_GAME = "2";
    private static final int BASEBALL_COUNT = 3;

    public void validateInput(String userNumbers) {
        validateInputLength(userNumbers);
        validateInputRanges(userNumbers);
        validateIsDuplicate(userNumbers);
    }

    public void validateInputRanges(final String numbers) {
        for (char number : numbers.toCharArray()) {
            if (!isNumber(number) || isZeroNumber(number)) {
                throw new IllegalArgumentException(IS_OUT_OF_RANGE_MESSAGE);
            }
        }
    }

    private boolean isNumber(final char number) {
        return Character.isDigit(number);
    }

    private boolean isZeroNumber(final char number) {
        return number == '0';
    }

    public void validateInputLength(final String numbers) {
        if (numbers.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException(IS_SUITABLE_LENGTH_MESSAGE);
        }
    }

    public void validateIsDuplicate(final String numbers) {
        List<Integer> inputNumbers = new Converter().convertStringToListInteger(numbers);
        Set<Integer> duplicateCheckNumberSet = new HashSet();

        for (int number : inputNumbers) {
            if (duplicateCheckNumberSet.contains(number)) {
                throw new IllegalArgumentException(IS_DUPLICATED_MESSAGE);
            }
            duplicateCheckNumberSet.add(number);
        }
    }

    public boolean validateInputContinue() {
        System.out.println(GameStatus.QUIT.message());
        String inputContinue = Console.readLine();

        if (inputContinue.equals(RESTART_BASEBALL_GAME)) {
            return true;
        } else if (inputContinue.equals(QUIT_BASEBALL_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(GameStatus.ERROR_CODE.message());
    }
}
