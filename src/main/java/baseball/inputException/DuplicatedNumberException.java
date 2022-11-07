package baseball.inputException;

public class DuplicatedNumberException extends IllegalArgumentException{

    public DuplicatedNumberException() {
        super("number can not have duplicated digit.");
    }
}
