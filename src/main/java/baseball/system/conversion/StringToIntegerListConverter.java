package baseball.system.conversion;

import baseball.system.ValidatorHolder;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter implements Converter<String, List<Integer>> {
    @Override
    public boolean supports(Object from, Class to) {
        return from.getClass() == String.class && to == List.class;
    }

    @Override
    public List<Integer> convert(String target) {
        ValidatorHolder.validate(target, List.class);

        return target
                .chars().map(Character::getNumericValue)
                .boxed().collect(Collectors.toList());
    }
}
