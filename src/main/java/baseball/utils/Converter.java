package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> toIntegerList(String string) {
        List<String> stringList = List.of(string.split(""));
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
