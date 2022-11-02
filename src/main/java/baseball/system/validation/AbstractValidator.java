package baseball.system.validation;

abstract public class AbstractValidator<T> implements Validator<T> {
    public static final String INVALID_INPUT_FOR_VALIDATOR_MESSAGE_FORMAT = "%s의 검증 작업을 실행하기에 유효한 입력이 아닙니다.";

    @Override
    public void validate(T target) {
        checkSupports(target);
        doValidate(target);
    }

    protected void throwValidatorNotSupportedException(String className) {
        throw new IllegalArgumentException(String.format(INVALID_INPUT_FOR_VALIDATOR_MESSAGE_FORMAT, className));
    }

    abstract protected void checkSupports(Object target);

    abstract protected void doValidate(T target);
}
