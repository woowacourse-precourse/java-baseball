package baseball.domain;

import baseball.util.Validation;

import java.util.List;

import static baseball.domain.User.UserValidation.*;
import static baseball.util.Constant.*;
import static baseball.util.Utilization.convertStringToIntegerList;

public class User {
    private List<Integer> numbers;

    public User() {}

    public void generateNumbers(String input) {
        if (!validateUserNumber(input)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER);
        }
        numbers = convertStringToIntegerList(input);
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
        public static boolean validateUserNumber(String input) {
            return validateStringLength(input, NUMBER_LENGTH)
                    && validateEachUserNumberInRange(input)
                    && validateNumberNotRepeated(convertStringToIntegerList(input), NUMBER_LENGTH);
        }

        public static boolean validateRestartValue(String input) {
            return validateRestartValueInRange(input);
        }

        private static boolean validateEachUserNumberInRange(String input) {
            for (int number : convertStringToIntegerList(input)) {
                if (!validateIntegerRange(number, MIN_NUMBER_VALUE, MAX_NUMBER_VALUE))
                    return false;
            }
            return true;
        }

        private static boolean validateRestartValueInRange(String input) {
            return Integer.parseInt(input) == GAME_RESTART_VALUE
                    || Integer.parseInt(input) == GAME_TERMINATE_VALUE;
        }
    }
}
