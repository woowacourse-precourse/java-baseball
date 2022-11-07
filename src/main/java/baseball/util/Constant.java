package baseball.util;

public class Constant {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int NUM_LENGTH = 3;

    public static final int ANSWER_LENGTH = 3;
    public static final String CONSIST_OF_NUM = "^[1-9]*$";
    public static final String ERROR_LENGTH_THREE = "[error] 제시한 답의 길이가 3이 아닙니다.";
    public static final String ERROR_CONSIST_OF_NUM = "[error] 제시한 답은 숫자로만 구성되어 있지 않습니다.";
    public static final String ERROR_OVERLAP_NUM = "[error 제시한 답은 서로다른 숫자로 구성되어 있지 않습니다.";
    public static final String ERROR_INPUT = "[error] 잘못된 값이 입력되었습니다.";

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
}
