package baseball.validation;

import baseball.constant.GameProcedureConstantInteger;
import baseball.constant.UserInputErrorConstantString;
import java.util.stream.Collectors;

public class Validation {

    public static void userBaseballInputValidation(String userInput) {
        isInputLengthValidate(userInput, GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue());
        isInteger(userInput, GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue());
        isValidInterval(userInput, GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_START.getIntegerValue(),
                GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_FINISH.getIntegerValue(),
                GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue());
        isContainsDuplicate(userInput, GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue());
    }

    private static void isContainsDuplicate(String userInput, int inputLength) {
        if (inputLength == userInput.chars()
                .mapToObj(charDigit -> charDigit - '0')
                .collect(Collectors.toSet())
                .size()) {
            return;
        }

        throw new IllegalArgumentException(UserInputErrorConstantString.CONTAINS_DUPLICATE_ERROR.getStringMessage());

    }

    private static void isValidInterval(String userInput, int startDigit, int finishDigit, int integerLength) {
        for (int i = 0; i < integerLength; i++) {
            if (!((char) startDigit <= userInput.charAt(i) && userInput.charAt(i) <= (char) finishDigit)) {
                throw new IllegalArgumentException(UserInputErrorConstantString.NOT_BETWEEN_DESIRABLE_INTERVAL_ERROR.getStringMessage());
            }
        }
    }

    private static void isInteger(String userInput, int inputLength) {
        for (int i = 0; i < inputLength; i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException(UserInputErrorConstantString.CONTAINS_NON_INTEGER_ERROR.getStringMessage());
            }
        }
    }

    private static void isInputLengthValidate(String userInput, int inputLength) {
        if (userInput.length() == inputLength) {
            return;
        }
        throw new IllegalArgumentException(UserInputErrorConstantString.LENGTH_ERROR.getStringMessage());
    }
}
