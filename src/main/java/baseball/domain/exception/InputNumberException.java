package baseball.domain.exception;

import baseball.domain.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class InputNumberException {

    public static List<Character> list;

    public static void inputNumberVerifier(String numbers) {
        list = new ArrayList<>();
        isNumbersLengthThree(numbers);
        isOnlyNumber(numbers);
        isNumbersOneToNine(numbers);
        isDuplicateCharacters(numbers);
    }

    private static void isNumbersLengthThree(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException(Constants.NUMBER_THREE_LENGTH);
        }
    }

    private static void isNumbersOneToNine(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '0') {
                throw new IllegalArgumentException(Constants.NOT_INPUT_ZERO);
            }
        }
    }

    public static void isInputNumberOneOrTwo(int number) {
        if (number < 1 || 2 < number) {
            throw new IllegalArgumentException(Constants.ONLY_ONE_OR_TWO);
        }
    }

    private static void isOnlyNumber(String numbers) {
        String regExp = Constants.ONLY_NUMBER_REGEX;
        if (!numbers.matches(regExp)) {
            throw new IllegalArgumentException(Constants.ONLY_INPUT_NUMBER);
        }
    }

    private static void isDuplicateCharacters(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (isAlreadyExistsCharacter(numbers.charAt(i))) {
                throw new IllegalArgumentException(Constants.NOT_INPUT_DUPLICATED_NUMBER);
            } else {
                list.add(numbers.charAt(i));
            }
        }
    }

    private static boolean isAlreadyExistsCharacter(char c) {
        for (char character : list) {
            if (character == c) {
                return true;
            }
        }
        return false;
    }

}
