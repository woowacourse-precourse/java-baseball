package baseball.inputException;

public class ContainingZeroException extends IllegalArgumentException{

    public ContainingZeroException() {
        super("number can not contain zero.");
    }
}
