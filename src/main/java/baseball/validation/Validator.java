package baseball.validation;

public interface Validator<T> {

    boolean validate(T target);
}
