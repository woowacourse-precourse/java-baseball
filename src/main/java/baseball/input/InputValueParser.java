package baseball.input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputValueParser {

    public List<Integer> inputValueToList(String inputValue) {
        return IntStream.range(0, 3)
                .mapToObj(i -> Integer.parseInt(inputValue.substring(i, i + 1)))
                .collect(Collectors.toList());
    }
}
