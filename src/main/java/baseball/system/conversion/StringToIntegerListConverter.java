package baseball.system.conversion;

import baseball.system.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter implements Converter<String, List<Integer>> {
    private final Validator<String> validator;

    public StringToIntegerListConverter(Validator<String> validator) {
        this.validator = validator;
    }

    @Override
    public boolean supports(Object from, Class to) {
        return from.getClass() == String.class && to == List.class;
    }

    @Override
    public List<Integer> convert(String target) {
        validator.validate(target);

        return target
                .chars().map(Character::getNumericValue)
                .boxed().collect(Collectors.toList());
    }
}
