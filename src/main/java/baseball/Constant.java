package baseball;

public class Constant {
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;
    public static final int DIGITS = 3;
    public static final String RESTART = "1";
    public static final String END = "2";

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_OVER_MESSAGE = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", DIGITS);
    public static final String RESTART_MESSAGE = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART, END);

    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";

    public static final String GUESSED_NUMBER_REGEX = String.format("[%d-%d]{%d}", MIN_DIGIT, MAX_DIGIT, DIGITS);
    public static final String RESTART_NUMBER_REGEX = String.format("[%s%s]", RESTART, END);
}
