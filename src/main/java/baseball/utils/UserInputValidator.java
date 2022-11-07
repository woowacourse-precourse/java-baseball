package baseball.utils;

import java.util.HashSet;
import java.util.Objects;

import static baseball.utils.Constants.*;

public class UserInputValidator {

    private static void throwError() {
        throw new IllegalArgumentException();
    }

    public static void validateUserInput(String userInput) {
        // 입력 길이(3) 초과해서 입력
        if (inputLengthExceeded(userInput)) {
            throwError();
        }
        // 숫자가 아닌 값 입력
        if (inputNonNumeric(userInput)) {
            throwError();
        }
        // 서로 같은 수 입력
        if (inputDuplicatedNumber(userInput)) {
            throwError();
        }
    }

    public static void validateUserInputForNewGame(String userInput) {
        if (!(Objects.equals(userInput, GAME_RESTART) || Objects.equals(userInput, GAME_END))) {
            throwError();
        }
    }

    private static boolean inputLengthExceeded(String input) {
        return input.length() > MAX_NUMBER_SIZE;
    }

    private static boolean inputNonNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean inputDuplicatedNumber(String input) {
        HashSet<Character> numberSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            Character num = input.charAt(i);
            numberSet.add(num);
        }
        return numberSet.size() != MAX_NUMBER_SIZE;
    }

    private static boolean isDigit(Character ch) {
        return '0' <= ch && ch <= '9';
    }
}
