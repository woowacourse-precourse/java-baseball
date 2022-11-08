package baseball.constant;

public class constants {

    public static final String RESTART = "1";
    public static final String EXIT = "2";

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int NUMBER_LIMIT_LENGTH = 3;

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public static final String FALSE_RANGE = NUMBER_LIMIT_LENGTH + "자리 수를 입력해주세요.";
    public static final String NOT_NUMBER = "숫자가 아닌 문자가 입력되었습니다.";
    public static final String DUPLICATE_NUMBER = "중복된 숫자가 입력되었습니다.";
    public static final String NOT_FOR_RESTART = String.format("%d 또는 %d를 입력해 주세요.",RESTART,EXIT);
}
