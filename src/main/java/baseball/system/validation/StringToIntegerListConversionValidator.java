package baseball.system.validation;

import java.util.List;

public class StringToIntegerListConversionValidator implements Validator<String> {
    public static final String VALUE_NOT_NATURAL_NUMBER_MESSAGE = "입력값은 정수로만 이루어져야 합니다.";
    public static final String ONLY_NATURAL_NUMBER_REGEX = "^[0-9]+";

    @Override
    public boolean supports(Object target, Class<?> to) {
        return target != null && target.getClass() == String.class && to == List.class;
    }

    @Override
    public void validate(String target) {
        hasStringOnlyIntegers(target);
    }

    private void hasStringOnlyIntegers(String target) {
        if (!target.matches(ONLY_NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(VALUE_NOT_NATURAL_NUMBER_MESSAGE);
        }
    }
}
