package baseball.inputException;

public class InvalidNumberException extends IllegalArgumentException{
    public InvalidNumberException() {
        super("Number can not have non-numeric value.");
    }
}
