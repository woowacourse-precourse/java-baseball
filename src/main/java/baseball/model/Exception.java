package baseball.model;

import java.util.List;
import java.util.regex.Pattern;

public class Exception {
    public static void validateUniqueNumber(List<Integer> numberList, int checkIndex) throws IllegalArgumentException {
        for (int i = 0; i < numberList.size(); i++) {
            if (checkIndex == i) {
                continue;
            }
            if (numberList.get(checkIndex) == numberList.get(i)) {
                throw new IllegalArgumentException("number is cannot duplicate.");
            }
        }
    }

    public static void validateInputSize(String input) throws IllegalArgumentException {
        final int INPUT_SIZE = 3;
        if (input.length() != INPUT_SIZE) {
            throw new IllegalArgumentException("input has to be 3 length.");
        }
    }

    public static void validateDigitRange(String input) throws IllegalArgumentException {
        final String REGEX = "^[1-9]*$";
        if (!Pattern.matches(REGEX, input)) {
            throw new IllegalArgumentException("digit range is a number of from 1 to 9.");
        }
    }

    public static void validateChoiceNumber(String input) throws IllegalArgumentException {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("only 1 or 2 number is possible.");
        }
    }
}
