package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    private Util() {}

    public static int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> toList(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
