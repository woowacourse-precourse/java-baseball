package baseball;

import java.util.ArrayList;

public class PlayerInputValueExceptions {

    static void allInputValueException(ArrayList<String> userSelectedNumbers) {
        isThreeDigitsNumber(userSelectedNumbers);
        haveDuplicateNumbers(userSelectedNumbers);
    }

    static void isThreeDigitsNumber(ArrayList<String> userSelectedNumbers) {
        if (userSelectedNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리만 입력하세요");
        }
    }

    static void haveDuplicateNumbers(ArrayList<String> userSelectedNumbers) {
        if (userSelectedNumbers.size() != userSelectedNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요");
        }
    }

    static void whenExitingIsNumberOneOrTwo(String userSelectedNumber) {
        if (!(userSelectedNumber.equals("1") || userSelectedNumber.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력하세요");
        }
    }
}

