package baseball.settings;

public class Constants {
    public final static int START_NUMBER = 1;
    public final static int END_NUMBER = 9;
    public final static int THREE_DIGITS = 3;
    public final static int INITIAL_COUNT = 0;
    public final static int BALL_INDEX = 0;
    public final static int STRIKE_INDEX = 1;

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String ENTER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public final static String VALID_NUMBER_REGEX = "^[1-9]{3}$";
    public final static String BALL_MESSAGE = "볼";
    public final static String STRIKE_MESSAGE = "스트라이크";
    public final static String NOTHING_MESSAGE = "낫싱";
    public final static String SPACE_BETWEEN_WORDS = " ";
    public final static String NO_SPACE = "";
    public final static String CONGRATULATIONS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String ASK_WHETHER_PLAYING_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String ONE_FOR_YES = "1";
    public final static String TWO_FOR_NO = "2";
}
