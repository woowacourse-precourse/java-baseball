package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.INPUT_LENGTH;

public class Utils {
    public static boolean isOneToNine(String input) {
        return input != null && input.matches("[1-9]+");
    }

    public static boolean isNotDuplicate(String input) {
        return Arrays.asList(input.split(""))
                .stream()
                .distinct()
                .count() == INPUT_LENGTH;
    }

    public static List<Integer> stringToIntList(String input) {
        return Arrays.asList(input.split(""))
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
