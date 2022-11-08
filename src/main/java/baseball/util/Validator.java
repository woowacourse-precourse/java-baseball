package baseball.util;

public interface Validator {
    boolean validateDigit(String input);

    boolean validateLength(String input);

    boolean validateDuplicate(String input);
}
