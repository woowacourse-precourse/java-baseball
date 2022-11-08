package baseball;

public class Constant {
    public static final int CORRECT_ANSWER_NUMBER_SIZE = 3;

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String ALERT_INPUT_ANSWER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GUESS_RESULT_BALL_MESSAGE = "%d볼 ";
    public static final String GUESS_RESULT_STRIKE_MESSAGE = "%d스트라이크";
    public static final String GUESS_RESULT_NOTHING_MESSAGE = "낫싱";
    public static final String SUCCESS_RESULT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String INPUT_ANSWER_IS_NOT_DIGIT_ERROR_MESSAGE = "숫자가 아닙니다.";
    public static final String INPUT_ANSWER_IS_NOT_ENOUGH_SIZE_ERROR_MESSAGE =
            CORRECT_ANSWER_NUMBER_SIZE + "자리 수여야합니다.";
    public static final String INPUT_ANSWER_IS_DUPLICATED_ERROR_MESSAGE = "중복되는 숫자가 존재합니다.";
    public static final String RESTART_INPUT_INVALID_ERROR_MESSAGE = "1이나 2를 입력하세요.";

    public static final String RESTART_INPUT_NUMBER = "1";
    public static final String EXIT_INPUT_NUMBER = "2";
}
