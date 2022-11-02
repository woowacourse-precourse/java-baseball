package baseball.system.conversion;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String target) {
        return target
                .chars().map(Character::getNumericValue)
                .boxed().collect(Collectors.toList());
    }
}
