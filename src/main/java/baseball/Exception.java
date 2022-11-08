package baseball;

import java.util.Arrays;

public class Exception {
    public static boolean isOneToNine(String input) {
        return input != null && input.matches("[1-9]+");
    }

    public static boolean isNotDuplicate(String input) {
        return Arrays.asList(input.split(""))
                .stream()
                .distinct()
                .count() == 3;
    }
}
