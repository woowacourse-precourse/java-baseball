package baseball.system.conversion;

import baseball.system.validation.StringToIntegerListConversionValidator;
import baseball.system.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String target) {
        Validator<String> validator = new StringToIntegerListConversionValidator();
        validator.validate(target);

        return target
                .chars().map(Character::getNumericValue)
                .boxed().collect(Collectors.toList());
    }
}
