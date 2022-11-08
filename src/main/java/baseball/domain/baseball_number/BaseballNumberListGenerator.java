package baseball.domain.baseball_number;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumberListGenerator {
    public static List<BaseballNumber> baseballNumberListOfRandomNumbers() {
        List<Integer> randomNumbers = RandomNumberGenerator.randomNumbers();
        return IntStream.range(0, 3)
                .mapToObj(idx -> new BaseballNumber(idx, randomNumbers.get(idx)))
                .collect(Collectors.toList());
    }

    public static List<BaseballNumber> baseballNumberList(String inputNumber) {
        return IntStream.range(0, 3)
                .mapToObj(idx ->
                        new BaseballNumber(
                                idx,
                                Integer.parseInt(inputNumber.substring(idx, idx + 1))
                        ))
                .collect(Collectors.toList());
    }
}
