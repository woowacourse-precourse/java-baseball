package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static final String USER_INPUT_IS_NULL_OR_EMPTY = "사용자 입력값이 null이거나 비었습니다.";
    public static final String USER_INPUT_IS_NOT_IN_RANGE = "사용자 입력값이 1~9 사이가 아닙니다.";
    public static final String USER_INPUT_IS_NOT_THREE_DIGITS = "사용자 입력값이 3자리가 아닙니다.";
    public static final String USER_INPUT_HAS_DUPLICATED_NUMBER = "중복된 값은 입력할 수 없습니다";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        validateUserInput(userInput);
    }

    static List<Integer> generateThreeDigitsNumber() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    static void validateUserInput(String userInput) {

        validateUserInputIsNullOrEmpty(userInput);
        validateUserInputIsThreeDigits(userInput);
        validateUserInputIsMinRangeToMaxRange(userInput);
        validateUserInputHasDuplicateNumber(userInput);
    }

    static void validateUserInputHasDuplicateNumber(String userInput) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';

            if (set.contains(userInputIntValue)) {
                throw new IllegalArgumentException(USER_INPUT_HAS_DUPLICATED_NUMBER);
            }

            set.add(userInputIntValue);
        }
    }

    static void validateUserInputIsMinRangeToMaxRange(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';
            if (!(1 <= userInputIntValue && userInputIntValue <= 9)) {
                throw new IllegalArgumentException(USER_INPUT_IS_NOT_IN_RANGE);
            }
        }
    }

    static void validateUserInputIsThreeDigits(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(USER_INPUT_IS_NOT_THREE_DIGITS);
        }
    }

    static void validateUserInputIsNullOrEmpty(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(USER_INPUT_IS_NULL_OR_EMPTY);
        }
    }
}
