package baseball.userInterface;

import java.util.List;

public class InputValidator {
    private static final String CONTAIN_CHARACTER = "입력값에 문자가 포함되었습니다. 숫자만 입력해주세요.";
    private static final String INPUT_LENGTH_IS_NOT_THREE = "입력값의 길이가 3이 아닙니다. 숫자 3개를 입력해주세요.";
    private static final String CONTAIN_DUPLICATE_NUMBER = "중복된 숫자가 포함되어있습니다. 서로 다른 숫자 3개를 입력해주세요.";
    private static final String INPUT_LENGTH_IS_NOT_ONE = "입력값의 길이가 1이 아닙니다. 숫자 1개를 입력해주세요.";
    private static final String INPUT_IS_NOT_ONE_OR_TWO = "입력값이 1 또는 2이 아닙니다. 1과 2 중 하나를 입력해주세요.";

    public static void validateUserInput(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(CONTAIN_CHARACTER);
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(INPUT_LENGTH_IS_NOT_THREE);
        }
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(0) == userInput.charAt(2) || userInput.charAt(1) == userInput.charAt(2)) {
            throw new IllegalArgumentException(CONTAIN_DUPLICATE_NUMBER);
        }
    }

    public static void validateIsPlayAgainCode(String isPlayAgainCode) {
        if (!isPlayAgainCode.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(CONTAIN_CHARACTER);
        }
        if (isPlayAgainCode.length() != 1) {
            throw new IllegalArgumentException(INPUT_LENGTH_IS_NOT_ONE);
        }
        if (!List.of("1", "2").contains(isPlayAgainCode)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_ONE_OR_TWO);
        }
    }
}
