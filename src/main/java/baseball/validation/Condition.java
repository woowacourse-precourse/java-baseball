package baseball.validation;

public interface Condition {
    Boolean isTrue(String guess);

    String getErrorMessage();
}
