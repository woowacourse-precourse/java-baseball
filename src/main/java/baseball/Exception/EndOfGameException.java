package baseball.Exception;

public class EndOfGameException extends RuntimeException{
    public static final String MESSAGE = "3스트라이크 아웃";

    public EndOfGameException(){
        super(MESSAGE);
    }
}
