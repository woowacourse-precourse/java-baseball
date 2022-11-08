package baseball.config;

/**
 * 컨트롤러에서 사용되는 모든 메시지가 모여있는 클래스 입니다
 */
public final class ControllerConstants {

    public static final String COMMAND_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String COMMAND_ERROR_MESSAGE = "1이나 2가 아닌 값이 입력되었습니다";

    private ControllerConstants() {
    }
}
