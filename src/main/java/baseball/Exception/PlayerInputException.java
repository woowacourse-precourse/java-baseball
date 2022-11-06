package baseball.Exception;

public class PlayerInputException extends RuntimeException{
    private static final String message = "플레이어의 입력 숫자가 잘못되었습니다.";

    public PlayerInputException() {
        super(message);
    }
}
