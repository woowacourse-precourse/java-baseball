package baseball;

public class EndGameException extends RuntimeException{
    private String message = "게임을 종료합니다";

    public EndGameException() {
        super();
    }

}
