package baseball;

import org.assertj.core.api.ThrowableAssert;

import java.util.HashSet;

public class Validator {
    public static final String LENGTH_ERROR_MESSAGE = "3자리 수가 아닙니다";
    public static final String NUMERIC_ERROR_MESSAGE = "숫자가 아닙니다";
    public static final String CONTAINS_ZERO_ERROR_MESSAGE = "0이 포함되어 있습니다";
    public static final String DUPLICATE_ERROR_MESSAGE = "중복되는 숫자가 있습니다";
    public static final String INVALID_CHOICE_ERROR_MESSAGE = "1 또는 2를 입력해야 합니다";
    public static final boolean VALIDATE_SUCCESS = true;
    public static final boolean VALIDATE_FAIL = false;
    public static final int LENGTH_LIMIT = 3;
    public static final String REGAME_CHOICE = "1";
    public static final String STOP_CHOICE = "2";
    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

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
            this.errorMessage = LENGTH_ERROR_MESSAGE;
            return VALIDATE_FAIL;
        }
        if (!isNumeric(userInput)) {
            this.errorMessage = NUMERIC_ERROR_MESSAGE;
            return VALIDATE_FAIL;

        }
        if (ContainsZero(userInput)) {
            this.errorMessage = CONTAINS_ZERO_ERROR_MESSAGE;
            return VALIDATE_FAIL;

        }
        if (hasDuplicateNumber(userInput)) {
            this.errorMessage = DUPLICATE_ERROR_MESSAGE;
            return VALIDATE_FAIL;
        }
        return VALIDATE_SUCCESS;
    }

    public boolean validateChoice(String userChoice) {
        if (!userChoice.equals(REGAME_CHOICE) && !userChoice.equals(STOP_CHOICE)) {
            this.errorMessage = INVALID_CHOICE_ERROR_MESSAGE;
            return VALIDATE_FAIL;
        }
        return VALIDATE_SUCCESS;
    }
}
