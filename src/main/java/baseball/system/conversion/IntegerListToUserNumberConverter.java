package baseball.system.conversion;

import baseball.system.ValidatorHolder;
import baseball.vo.UserNumber;

import java.util.List;

public class IntegerListToUserNumberConverter implements Converter<List<Integer>, UserNumber> {
    @Override
    public boolean supports(Object from, Class to) {
        return from instanceof List && to == UserNumber.class;
    }

    @Override
    public UserNumber convert(List<Integer> target) {
        ValidatorHolder.validate(target, UserNumber.class);
        return UserNumber.of(target);
    }
}
