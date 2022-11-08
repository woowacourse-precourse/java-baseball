package baseball.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int VALID_INPUT_DIGIT = 3;
    private static final String VALID_INPUT_TYPE = "^[1-9]{3}$";

    public static List<Integer> validateUserInput(String userInput) {
        validateDigit(userInput);
        validateType(userInput);
        validateDuplicates(userInput);

        return finishValidation(userInput);
    }

    private static void validateDigit(String userInput) {
        if (userInput.length() != VALID_INPUT_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateType(String userInput) {
        if (!userInput.matches(VALID_INPUT_TYPE)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicates(String userInput) {
        Set<Character> characterSet = new HashSet<>();
        for (Character character : userInput.toCharArray()) {
            characterSet.add(character);
        }

        if (characterSet.size() != VALID_INPUT_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> finishValidation(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (Character character : userInput.toCharArray()) {
            userInputList.add(Integer.parseInt(String.valueOf(character)));
        }

        return userInputList;
    }

}
