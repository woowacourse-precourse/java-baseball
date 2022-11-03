package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<Integer> convertStringToIntegerList(String input) {
        String[] inputToArray = input.split("");
        return Arrays.stream(inputToArray)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
