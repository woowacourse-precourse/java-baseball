package baseball.domain;

import baseball.util.Validation;

import java.util.List;

import static baseball.domain.User.UserInputValidation.*;
import static baseball.util.Constant.*;
import static baseball.util.Utilization.convertStringToIntegerList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private List<Integer> numbers;

    public User() {}

    public void generateNumbers() {
        String userInput = input();
        if (!validateUserNumber(userInput)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER);
        }
        numbers = convertStringToIntegerList(userInput);
    }

    public int inputRestart() {
        String userInput = input();
        if (!validateRestartValue(userInput)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER);
        }
        return Integer.parseInt(userInput);
    }

    private String input() {
        String userInput = readLine();
        if (!validateInput(userInput)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_INPUT);
        }
        return userInput;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    static class UserInputValidation extends Validation {
        public static boolean validateInput(String userInput) {
            return validateNotNull(userInput)
                    && isInteger(userInput);
        }

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
