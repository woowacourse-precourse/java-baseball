package baseball.system.validation;

public interface Validator<T> {
    void validate(T target);
}
