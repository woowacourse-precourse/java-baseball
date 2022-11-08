package baseball.constant;

public final class Constants {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_LENGTH = 3;
    public static final int MAX_STRIKE = 3;
    public static final int RESTART_CHOICE = 1;
    public static final int INIT_COUNT = 0;

    public static final String RANGE_FORMAT_PATTERN = "(^[1-9]*$)";
    public static final String REPEATED_PATTERN = "(.)\\1+";
    public static final String RESTART = "1";
    public static final String QUIT = "2";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맟히셨습니다! ";
    public static final String GAME_FINISH_MESSAGE = "게임 종료";
    public static final String RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "1에서 9사이의 숫자만 입력해주세요.";
    public static final String NUMBER_LENGTH_ERROR_MESSAGE = "올바른 길이의 숫자를 입력해주세요.";
    public static final String REPEATED_NUMBER_ERROR_MESSAGE = "서로 다른 숫자를 입력해주세요.";
    public static final String CHOICE_ERROR_MESSAGE = "1 또는 2를 입력해주세요.";
}
