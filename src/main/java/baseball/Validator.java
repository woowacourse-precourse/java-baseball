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

    public boolean validateInput(String userInput) {
        if (!isThreeLetters(userInput)) {
            throw new IllegalArgumentException("3자리 수가 아닙니다");
        }

        return VALIDATE_SUCCESS;
    }
}
