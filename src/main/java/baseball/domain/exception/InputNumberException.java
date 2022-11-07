package baseball.domain.exception;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.exception.ExceptionConstants.*;

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
            throw new IllegalArgumentException(NUMBER_THREE_LENGTH);
        }
    }

    private static void isNumbersOneToNine(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '0') {
                throw new IllegalArgumentException(NOT_INPUT_ZERO);
            }
        }
    }

    public static void isInputNumberOneOrTwo(int number) {
        if (number < 1 || 2 < number) {
            throw new IllegalArgumentException(ONLY_ONE_OR_TWO);
        }
    }

    private static void isOnlyNumber(String numbers) {
        if (!numbers.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ONLY_INPUT_NUMBER);
        }
    }

    private static void isDuplicateCharacters(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (isAlreadyExistsCharacter(numbers.charAt(i))) {
                throw new IllegalArgumentException(NOT_INPUT_DUPLICATED_NUMBER);
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
