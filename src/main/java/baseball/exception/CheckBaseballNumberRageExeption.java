package baseball.exception;

public class CheckBaseballNumberRageExeption extends IllegalArgumentException {
    public CheckBaseballNumberRageExeption() {
        super("1 - 9 사이의 값을 입력해주세요");
    }
}
