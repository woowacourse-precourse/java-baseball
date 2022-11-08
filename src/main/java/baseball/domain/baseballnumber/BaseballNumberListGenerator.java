package baseball.domain.baseballnumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class BaseballNumberListGenerator {

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;

    public static List<BaseballNumber> baseballNumberListOfRandomNumbers() {
        List<Integer> randomNumbers = RandomNumberGenerator.randomNumbers();

        return IntStream.rangeClosed(START_INDEX, END_INDEX)
                .mapToObj(idx -> new BaseballNumber(idx, randomNumbers.get(idx)))
                .collect(Collectors.toList());
    }

    public static List<BaseballNumber> baseballNumberList(String inputNumber) {
        return IntStream.rangeClosed(START_INDEX, END_INDEX)
                .mapToObj(idx ->
                        new BaseballNumber(
                                idx,
                                Integer.parseInt(inputNumber.substring(idx, idx + 1))
                        ))
                .collect(Collectors.toList());
    }
}
