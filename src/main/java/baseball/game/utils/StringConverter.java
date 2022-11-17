package baseball.game.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.game.config.constants.StringConverterMessage.ONLY_NUMBER;
import static baseball.game.config.constants.StringConverterMessage.ONLY_ONE_WORD_LIMIT;

public class StringConverter {

    public static int toInteger(String input) {
        if (input.length() > 1) {
            throw new IllegalArgumentException(ONLY_ONE_WORD_LIMIT);
        }
        checkChangeableToDigit(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegerList(String input) {
        checkChangeableToDigit(input);
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void checkChangeableToDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            checkDigit(input.charAt(i));
        }
    }

    private static void checkDigit(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }
}
