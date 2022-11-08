package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class PlayerInputValidator {
    private final static int PLAYER_ANSWER_CORRECT_SIZE = 3;
    private final static String PLAYER_ANSWER_REGEX = "^[1-9]*$";

    public List<Integer> validatePlayerAnswerInput(String playerInput) {
        validateThreeLength(playerInput);
        validateSatisfiedRange(playerInput);
        List<Integer> playerAnswerNumbers = convertStringToIntegerList(playerInput);
        validateIsNonDuplicateNums(playerAnswerNumbers);
        return playerAnswerNumbers;
    }

    public void validateReplayInputValidation(String replayInput) {
        if (!(replayInput.equals("1") || replayInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }

    private static void validateThreeLength(String inputNumbers) {
        if (inputNumbers.length() != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSatisfiedRange(String inputNumbers) {
        if (!inputNumbers.matches(PLAYER_ANSWER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNonDuplicateNums(List<Integer> input) {
        long individualNumberCount = input.stream()
                .distinct()
                .count();
        if (individualNumberCount != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
