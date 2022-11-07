package baseball.system.validation;

public interface Validator {
    boolean supports(Object target, Class<?> to);

    void validate(Object target);
}
