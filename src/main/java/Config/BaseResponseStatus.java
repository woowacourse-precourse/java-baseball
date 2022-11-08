package Config;

public class BaseResponseStatus {
    // GAME MESSAGE
    public static final String NUMERIC_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String RESULT_BALL = "볼";
    public static final String RESULT_STRIKE = "스트라이크";
    public static final String RESULT_NOTHING = "낫싱";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_TERMINATE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // GAME VARIABLE
    public static final int NUMBER_LENGTH = 3;
    public static final int START_OF_NUMBER = 1;
    public static final int END_OF_NUMBER = 9;
    public static final int RESTART = 1;
    public static final int TERMINATE = 2;

    // INPUT ERROR
    public static final String INVALID_INPUT_ERROR = "숫자야구는 세자리의 각각 다른 수를 입력하여야 합니다. 게임이 종료됩니다.";
}
