package baseball.domain;

import baseball.util.Validation;

import java.util.List;

import static baseball.domain.User.UserValidation.*;
import static baseball.util.Constant.*;
import static baseball.util.Utilization.convertStringToIntegerList;

public class User {
    private List<Integer> numbers;

    public User() {}

    public void generateNumbers(String value) {
        if (!validateUserNumber(value)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER);
        }
        numbers = convertStringToIntegerList(value);
    }

    public int generateRestart(String value) {
        if (!validateRestartValue(value)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER);
        }
        return Integer.parseInt(value);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    static class UserValidation extends Validation {
        public static boolean validateUserNumber(String userInput) {
            return validateStringLength(userInput, NUMBER_LENGTH)
                    && validateEachUserNumberInRange(userInput)
                    && validateNumberNotRepeated(convertStringToIntegerList(userInput), NUMBER_LENGTH);
        }

        public static boolean validateRestartValue(String userInput) {
            return validateRestartValueInRange(userInput);
        }

        private static boolean validateEachUserNumberInRange(String userInput) {
            for (int number : convertStringToIntegerList(userInput)) {
                if (!validateIntegerRange(number, MIN_NUMBER_VALUE, MAX_NUMBER_VALUE))
                    return false;
            }
            return true;
        }

        private static boolean validateRestartValueInRange(String userInput) {
            return Integer.parseInt(userInput) == GAME_RESTART_VALUE
                    || Integer.parseInt(userInput) == GAME_TERMINATE_VALUE;
        }
    }
}
