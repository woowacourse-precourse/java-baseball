package baseball.utils;

public class InputValidator {
    public static void validateUserInput(String userInput, int MAX_LENGTH) {
        validateLength(userInput, MAX_LENGTH);
        validateNumber(userInput);
        validateOverlap(userInput, MAX_LENGTH);
    }

    private static void validateLength(String userInput, int MAX_LENGTH) {
        if (userInput.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("You must enter only 3 numbers");
        }
    }

    private static void validateNumber(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("You must enter only number");
        }
    }

    private static void validateOverlap(String userInput, int MAX_LENGTH) {
        long count = userInput.chars()
                .distinct()
                .count();
        if (count != userInput.length()) {
            throw new IllegalArgumentException("You must enter " +
                    MAX_LENGTH +
                    "different numbers");
        }
    }
}
