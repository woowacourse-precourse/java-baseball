package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleNumberUtils {
    public static List<SingleNumber> singleNumberList(List<Integer> randomNumbers) {
        return IntStream.range(0, 3)
                .mapToObj(i -> new SingleNumber(i, randomNumbers.get(i)))
                .collect(Collectors.toList());
    }

    public static List<SingleNumber> singleNumberList(String inputNumber) {
        return IntStream.range(0, 3)
                .mapToObj(i -> new SingleNumber(
                        i,
                        Integer.parseInt(inputNumber.substring(i, i + 1))
                ))
                .collect(Collectors.toList());
    }

}
