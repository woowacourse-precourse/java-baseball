package baseball.input_number;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumberFactory {

    public static InputNumberList getInputNumberList(String inputValue) {
        List<Integer> inputValues = inputValueToList(inputValue);
        List<InputNumber> inputNumbers = integerToInputNumber(inputValues);

        return new InputNumberList(inputNumbers);
    }

    private static List<InputNumber> integerToInputNumber(List<Integer> inputValues) {
        return IntStream.range(0, 3)
                .mapToObj(i -> new InputNumber(i, inputValues.get(i)))
                .collect(Collectors.toList());
    }

    private static List<Integer> inputValueToList(String inputValue) {
        return IntStream.range(0, 3)
                .mapToObj(i -> Integer.parseInt(inputValue.substring(i, i + 1)))
                .collect(Collectors.toList());
    }
}
