package baseball.system.validation;

public interface Validator<T> {
    boolean supports(Object target, Class<?> to);

    void validate(T target);
}
