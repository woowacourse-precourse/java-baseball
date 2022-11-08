package baseball.userInterface;

import java.util.List;

public class InputValidator {
    public static void validateUserInput(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(0) == userInput.charAt(2) || userInput.charAt(1) == userInput.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsPlayAgainCode(String isPlayAgainCode) {
        if (!isPlayAgainCode.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (isPlayAgainCode.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (!List.of("1", "2").contains(isPlayAgainCode)) {
            throw new IllegalArgumentException();
        }
    }
}
