package baseball.game;

import java.util.Arrays;
import java.util.stream.Collectors;

import static baseball.game.BaseballGame.BASEBALL_LENGTH_LIMIT;

public class InputManager {

    private final static String DURING_GAME_INPUT_PATTERN = String.format("^[1-9]{%d}", BASEBALL_LENGTH_LIMIT);
    private final static String POST_GAME_INPUT_PATTERN = String.format("^[1-2]");

    public static void validateInputDuringGame(final String input) {
        checkNull(input);
        checkDuringGameInputPattern(input);
        checkAllDigitDistinct(input);
    }

    public static void validateInputPostGame(final String input) {
        checkNull(input);
        checkPostGameInputPattern(input);
    }

    private static void checkNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("INVALID INPUT : " + null);
        }
    }

    private static void checkDuringGameInputPattern(final String input) {
        if (input.matches(DURING_GAME_INPUT_PATTERN)) {
            return;
        }
        throw new IllegalArgumentException("INVALID INPUT : " + input);
    }

    private static void checkAllDigitDistinct(final String input) {
        final int inputLength = Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining()).length();
        if (inputLength != BASEBALL_LENGTH_LIMIT) {
            throw new IllegalArgumentException("INVALID INPUT : " + input);
        }
    }

    private static void checkPostGameInputPattern(final String input) {
        if (input.matches(POST_GAME_INPUT_PATTERN)) {
            return;
        }
        throw new IllegalArgumentException("INVALID INPUT : " + input);
    }
}
