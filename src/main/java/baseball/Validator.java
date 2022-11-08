package baseball;

import static baseball.Game.GAME_LENGTH;

public class Validator {
    public void validatePitchValue(String pitchValue) {
        if (!validateGameNumberLength(pitchValue)) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }

        if (!validateIsAllDigitExceptForZero(pitchValue)) {
            throw new IllegalArgumentException("0을 제외한 숫자만 입력해주세요.");
        }

        if (validateIsComposedOfSeparateNumbers(pitchValue)) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
        }
    }

    private boolean validateGameNumberLength(String value) {
        return value.length() == GAME_LENGTH;
    }

    private boolean validateIsAllDigitExceptForZero(String value) {
        for (int idx = 0; idx < value.length(); idx++) {
            if (!Character.isDigit(value.charAt(idx))) {
                return false;
            }
            if (value.charAt(idx) == '0') {
                return false;
            }
        }
        return true;
    }

    private boolean validateIsComposedOfSeparateNumbers(String value) {
        return hasSameNumber(value, 0, 0, "");
    }

    private boolean hasSameNumber(String value, int startIdx, int combinationLength, String combination) {
        if (combinationLength == 2) {
            if (compare(combination.charAt(0), combination.charAt(1))) {
                return true;
            }
        }
        boolean result = false;
        for (int idx = startIdx; idx < value.length(); idx++) {
            result = hasSameNumber(value, idx + 1, combinationLength + 1, combination + value.charAt(idx));
            if (result) {
                break;
            }
        }
        return result;
    }

    private boolean compare(char digit1, char digit2) {
        return digit1 == digit2;
    }

    public void validateGameProcessValue(String gameProcessValue) {
        if (!validateGameProcessLength(gameProcessValue)) {
            throw new IllegalArgumentException("1자리 수를 입력해주세요.");
        }

        if (!validateIsDigit(gameProcessValue)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (!validateIs1Or2(gameProcessValue)) {
            throw new IllegalArgumentException("게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수만 입력해주세요.");
        }
    }

    private boolean validateGameProcessLength(String value) {
        return value.length() == 1;
    }

    private boolean validateIsDigit(String value) {
        return Character.isDigit(value.charAt(0));
    }

    private boolean validateIs1Or2(String value) {
        return (value.charAt(0) - '0') == 1 || (value.charAt(0) - '0') == 2;
    }
}
