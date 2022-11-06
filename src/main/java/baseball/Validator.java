package baseball;

import org.assertj.core.api.ThrowableAssert;

public class Validator {
    public static final boolean VALIDATE_SUCCESS = true;
    public static final int LENGTH_LIMIT=  3;

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

        return VALIDATE_SUCCESS;
    }
}
