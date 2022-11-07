package baseball.outputgenerator;

/**
 * 게임의 각 케이스의 결과를 저장하는 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHO
 */
public class GameResult {
    private final boolean isSuccess; // 3스트라이크인지를 저장합니다.
    private final String message; // 출력 메시지를 저장합니다.

    public GameResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
