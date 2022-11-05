package baseball;

public final class SystemConstant {
    private SystemConstant() {
    }

    public static final int GAME_DIGIT = 3;
    public static final int GAME_RESTART_FLAG = 1;
    public static final int GAME_EXIT_FLAG = 2;
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END_MESSAGE = GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 " + GAME_RESTART_FLAG +
            ", 종료하려면 " + GAME_EXIT_FLAG + "를 입력하세요.";
    public static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
}