package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static final int ASCII_CODE_NINE = 57;
    public static final int ASCII_CODE_ONE = 49;
    public static final int INPUT_LENGTH = 3;

    public void verifyUserInGameInput(String userInput) {
        verifyIfNull(userInput);

        verifyIfLengthIsThree(userInput);

        verifyIfNumberIsInRange(userInput);

        verifyIfNumberIsDifferentEachOther(userInput);
    }

    private void verifyIfNumberIsDifferentEachOther(String userInput) {
        Set<Character> set = new HashSet<>(INPUT_LENGTH);

        for (char input : userInput.toCharArray()) {
            set.add(input);
        }

        if (isNotDifferentEachOtherNumber(set)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하셔야합니다.");
        }
    }

    private static boolean isNotDifferentEachOtherNumber(Set<Character> set) {
        return set.size() != INPUT_LENGTH;
    }

    private void verifyIfNumberIsInRange(String userInput) {
        for (char input : userInput.toCharArray()) {
            if (isInNumberRange(input)) {
                throw new IllegalArgumentException("입력은 1이상 9이하로 제한됩니다.");
            }
        }
    }

    private boolean isInNumberRange(char input) {
        return input < ASCII_CODE_ONE || ASCII_CODE_NINE < input;
    }

    private void verifyIfLengthIsThree(String userInput) {
        if (isNotLengthThree(userInput)) {
            throw new IllegalArgumentException("숫자 3개를 입력해야합니다.");
        }
    }

    private boolean isNotLengthThree(String userInput) {
        return userInput.length() != 3;
    }

    private void verifyIfNull(String userInput) {
        if (isNull(userInput)) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private boolean isNull(String userInput) {
        return userInput == null;
    }

    public void verifyRestartOrEndInput(String restartOrEndInput) {
        verifyIfNull(restartOrEndInput);
        if (isNotValidRestartOrEndInput(restartOrEndInput)) {
            throw new IllegalArgumentException("1과 2만 입력이 가능합니다.");
        }
    }

    private static boolean isNotValidRestartOrEndInput(String restartOrEndInput) {
        return !(restartOrEndInput.equals("1") || restartOrEndInput.equals("2"));
    }
}
