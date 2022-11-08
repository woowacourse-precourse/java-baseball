package baseball.exception;

public class CantDuplicatedNumberInputException extends IllegalArgumentException{
    public CantDuplicatedNumberInputException() {
        super("자리수 간 중복된 수를 가질 수 없습니다.");
    }
}
