package baseball.exception;

public class OnlyThreeNumberInputException extends IllegalArgumentException{
    public OnlyThreeNumberInputException() {
        super("3자리 수만 입력할 수 있습니다.");
    }
}
