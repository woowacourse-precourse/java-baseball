package baseball;

import static baseball.RandomNumberCreator.NUMBER_COUNT_TO_CREATED;

public class InputValidator {

    public final static String GAME_RESTART_OPTION = "1";
    public final static String GAME_CLOSE_OPTION = "2";

    public void validateAnswer(String input) {
        if (input.length() != NUMBER_COUNT_TO_CREATED) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRestartOption(String input) {
        if (!input.equals(GAME_RESTART_OPTION) && !input.equals(GAME_CLOSE_OPTION)) {
            throw new IllegalArgumentException();
        }
    }
}
