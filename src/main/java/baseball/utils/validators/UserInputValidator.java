package baseball.utils.validators;

import baseball.utils.Constants;
import baseball.utils.InputValueValidator;

public class UserInputValidator {

    public static void validateGameInput(String input) throws IllegalArgumentException{
        boolean isNumberOnly = InputValueValidator.isNumberOnly(input);
        boolean isNoDuplicated = InputValueValidator.isNoDuplicatedValue(input);
        boolean isLengthCorrect = InputValueValidator.isLengthCorrect(input, Constants.BASEBALL_GAME_NUMBER_LENGTH);

        if(!(isNumberOnly && isNoDuplicated && isLengthCorrect)){
            throw new IllegalArgumentException();
        }
    }

    public static void validateRetryInput(String input) throws IllegalArgumentException{
        boolean isOnlyNumber = InputValueValidator.isNumberOnly(input);
        boolean isOneLength = InputValueValidator.isLengthCorrect(input, 1);
        boolean isRetryValue = InputValueValidator.isContainValues(input, Constants.BASEBALL_GAME_END);

        if(!(isOnlyNumber && isOneLength && isRetryValue)){
            throw new IllegalArgumentException();
        }
    }
}
