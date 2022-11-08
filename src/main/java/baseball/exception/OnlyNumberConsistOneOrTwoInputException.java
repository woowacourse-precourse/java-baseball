package baseball.exception;

public class OnlyNumberConsistOneOrTwoInputException extends IllegalArgumentException{
    public OnlyNumberConsistOneOrTwoInputException() {
        super("1~2사이의 1자리 수만 입력할 수 있습니다.");
    }
}
