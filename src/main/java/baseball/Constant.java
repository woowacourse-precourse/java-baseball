package baseball;

public class Constant {

    public static final int CNT_NUMBER = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final String REGAX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]*$";

    public static final String START_CODE = "1";
    public static final String EXIT_CODE = "2";

    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String ALL_STRIKE = "3스트라이크";

    public static final String START_PROGRAM = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    public static final String EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String ALL_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
}
