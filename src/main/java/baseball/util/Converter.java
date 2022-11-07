package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Integer> stringListToIntList(String userNumber) {
        return stringToList(userNumber).stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> stringToList(String convertString) {
        return Arrays.asList(convertString.split(""));
    }
}
