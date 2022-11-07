package baseball;

import org.assertj.core.api.ThrowableAssert;

import java.util.HashSet;

public class Validator {
    public static final boolean VALIDATE_SUCCESS = true;
    public static final int LENGTH_LIMIT = 3;

    public boolean isThreeLetters(String userInput) {
        if (userInput.length() == LENGTH_LIMIT){
            return true;
        }
        return false;
    }

    public boolean isNumeric(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            if (!Character.isDigit(userInput.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    public boolean ContainsZero(String userInput) {
        return userInput.contains("0");
    }

    public boolean hasDuplicateNumber(String userInput) {
        HashSet<Character> inputs = new HashSet<>();
        for (int index = 0; index < LENGTH_LIMIT; index++) {
            inputs.add(userInput.charAt(index));
        }
        // inputs의 길이가 LENGTH_LIMIT 이하 = 중복되는 것이 있다.
        if (inputs.size() == LENGTH_LIMIT) {
            return false;
        }
        return true;
    }

    public boolean validateInput(String userInput) {
        if (!isThreeLetters(userInput)) {
            throw new IllegalArgumentException("3자리 수가 아닙니다");
        }
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
        if (ContainsZero(userInput)) {
            throw new IllegalArgumentException("0이 포함되어 있습니다");
        }
        if (hasDuplicateNumber(userInput)) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다");
        }
        return VALIDATE_SUCCESS;
    }

    public boolean validateChoice(String userChoice) {
        if (!userChoice.equals("1") && !userChoice.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다");
        }
        return VALIDATE_SUCCESS;
    }
}
