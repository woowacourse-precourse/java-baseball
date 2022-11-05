package baseball.inputparser;

/**
 * 입력 문자열의 타입을 가지는 enum 클래스입니다.
 * 각 입력 문자열이 게임의 어느 시점에 입력된 문자열인지 나타냅니다.
 * @version 1.0.0
 * @author CHO MinHO
 */
public enum InputType {
    /**
     * 게임이 진행 중일 때 입력되는 문자열을 의미합니다.
     */
    IN_GAME_INPUT,
    /**
     * 게임이 끝나고 재시작 여부를 물어볼때 입력되는 문자열을 의미합니다.
     */
    GAME_RESTART_INPUT
}
