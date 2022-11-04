package baseball.system.conversion;

import baseball.system.validation.Validator;
import baseball.vo.UserNumber;

import java.util.List;

public class IntegerListToUserNumberConverter implements Converter<List<Integer>, UserNumber> {
    private final Validator<List<Integer>> validator;

    public IntegerListToUserNumberConverter(Validator<List<Integer>> validator) {
        this.validator = validator;
    }

    @Override
    public boolean supports(Object from, Class to) {
        return from instanceof List && to == UserNumber.class;
    }

    @Override
    public UserNumber convert(List<Integer> target) {
        validator.validate(target);
        return UserNumber.of(target);
    }
}
