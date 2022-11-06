package baseball.game.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {

    public static int toInteger(String input) {
        if (input.length() > 1) {
            throw new IllegalArgumentException("1글자만 입력할 수 있습니다.");
        }
        checkChangeableToDigit(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegerList(String input) {
        checkChangeableToDigit(input);
        return Arrays.stream(input.split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkChangeableToDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            checkDigit(input.charAt(i));
        }
    }

    private static void checkDigit(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
