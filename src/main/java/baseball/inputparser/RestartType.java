package baseball.inputparser;

/**
 * 재시작 여부를 나타내는 enum 클래스입니다.
 * 게임 종료 시점에서 게임을 재시작할지, 종료할지 여부를 나타냅니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
public enum RestartType {
    /**
     * 게임을 재시작하는 경우
     */
    RESTART,
    /**
     * 게임을 종료하는 경우
     */
    QUIT
}
