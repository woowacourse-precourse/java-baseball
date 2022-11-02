package baseball.system.validation;

public class StringToIntegerListConversionValidator extends AbstractValidator<String> {
    public static final String VALUE_NOT_NATURAL_NUMBER_MESSAGE = "입력값은 정수로만 이루어져야 합니다.";
    public static final String ONLY_NATURAL_NUMBER_REGEX = "^[0-9]+";

    @Override
    protected void checkSupports(Object target) {
        if (target == null || target.getClass() != String.class) {
            throwValidatorNotSupportedException(this.getClass().getSimpleName());
        }
    }

    @Override
    protected void doValidate(String target) {
        hasStringOnlyIntegers(target);
    }

    private void hasStringOnlyIntegers(String target) {
        if (!target.matches(ONLY_NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(VALUE_NOT_NATURAL_NUMBER_MESSAGE);
        }
    }
}
