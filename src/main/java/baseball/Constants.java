package baseball;

public class Constants {

    public final static int ANSWER_NUM_CNT = 3;
    public final static int ANSWER_NUM_RANGE_START = 1;
    public final static int ANSWER_NUM_RANGE_END = 9;
    public final static int GAME_OVER_NO = 1;
    public final static int GAME_OVER_YES = 2;

    // 예외사항 메세지
    public final static String ONLY_NUMBER_EXCEPTION = "숫자로 이루어진 값이 아닙니다.";
    public final static String NUMBER_LENGTH_EXCEPTION = ANSWER_NUM_CNT + "자리 자연수가 아닙니다.";
    public final static String NUMBER_RANGE_EXCEPTION = "각자리 수가 1에서 9까지의 수로 이루어진 값이 아닙니다.";
    public final static String NUMBER_DUPLICATE_EXCEPTION = "각자리 수는 중복될 수 없습니다.";
    public final static String OVER_YN_EXCEPTION = "입력값이 1 또는 2가 아닙니다.";

    // 정답 힌트 목록
    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOTHING = "낫싱";

    // 출력 메세지
    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public final static String CORRECT_ANSWER_MESSAGE = ANSWER_NUM_CNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String INPUT_GAME_OVER_YN_MESSAGE
            = "게임을 새로 시작하려면 " + GAME_OVER_NO + ", 종료하려면 " + GAME_OVER_YES + "를 입력하세요.";
}
