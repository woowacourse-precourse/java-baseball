package baseball.inputException;

public class IllegalDigitsException extends IllegalArgumentException {

    public IllegalDigitsException() {
        super("digit is invalid.");
    }
}
