package baseball.domain.exception;

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
            throw new IllegalArgumentException("3개의 숫자만 입력 가능합니다.");
        }
    }

    private static void isNumbersOneToNine(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '0') {
                throw new IllegalArgumentException("1~9까지의 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void isInputNumberOneOrTwo(int number) {
        if (number < 1 || 2 < number) {
            throw new IllegalArgumentException("1과 2만 입력 가능합니다.");
        }
    }

    private static void isOnlyNumber(String numbers) {
        String regExp = "^[0-9]+$";
        if (!numbers.matches(regExp)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void isDuplicateCharacters(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (isAlreadyExistsCharacter(numbers.charAt(i))) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
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
