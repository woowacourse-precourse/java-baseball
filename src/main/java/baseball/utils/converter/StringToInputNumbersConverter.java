package baseball.utils.converter;

import baseball.model.InputNumber;
import baseball.model.InputNumbers;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StringToInputNumbersConverter implements Converter<String, InputNumbers>{
    @Override
    public InputNumbers convert(String source) {
        List<InputNumber> inputNumber = IntStream.range(0, source.length())
                .mapToObj(i -> new InputNumber(i, source.charAt(i) - '0'))
                .collect(toList());
        return new InputNumbers(inputNumber);
    }
}
