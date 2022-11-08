package baseball.message;

public final class SystemMessage {

    private SystemMessage() {}

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public final static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String TRY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String SYSTEM_RESTART = "1";
    public final static String SYSTEM_SHUTDOWN = "2";
}
