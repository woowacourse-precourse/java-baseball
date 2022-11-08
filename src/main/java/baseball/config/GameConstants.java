package baseball.config;

/**
 * Game에서 사용되는 모든 메시지, 상수가 모여 있는 클래스 입니다
 */
public final class GameConstants {
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    public static final int MIN_INPUT_INCLUSIVE = 100;
    public static final int MAX_INPUT_INCLUSIVE = 999;
    public static final int DIGIT_START = 0;
    public static final int DIGIT_END = 9;
    public static final int HUNDRED_START = 1;
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE =
            MIN_INPUT_INCLUSIVE + "개의 숫자를 모두 맞히셨습니다 !게임 종료\n";

    public static final String ONE_BALL = "1볼 ";
    public static final String TWO_BALL = "2볼 ";
    public static final String THREE_BALL = "3볼 ";

    public static final String ONE_STRIKE = "1스트라이크";
    public static final String TWO_STRIKE = "2스트라이크";
    public static final String THREE_STRIKE = "3스트라이크";

    public static final String NOTHING = "낫싱";
    public static final String DIGITS_OUT_OF_INDEX = "Digits의 최대 길이보다 큰 index를 참조했습니다";
    public static final String INPUT_OUT_OF_RANGE =
            MIN_INPUT_INCLUSIVE + "부터 " + MAX_INPUT_INCLUSIVE + "사이의 입력이 아닙니다";
    public static final String INPUT_DUPLICATE = "입력한 값중에 중복된 값이 있습니다";
    public static final String INPUT_ERROR = "사용자의 입력에 문제가 있습니다";

    private GameConstants() {
    }
}
