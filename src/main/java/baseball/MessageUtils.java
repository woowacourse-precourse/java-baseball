package baseball;

public class MessageUtils {
    public static final int STRIKE_COUNT = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int BALL_SET_SIZE = 3;

    public static final String START_TEXT= "1";
    public static final String FINISH_TEXT= "2";

    public static final String STRIKE_TEXT = "스트라이크";
    public static final String BALL_TEXT = "볼";
    public static final String NOTHING_TEXT = "낫싱";
    public static final String BLANK_SPACE = " ";

    public static final String NUMBER_OUT_OF_RANGE_MESSAGE = "야구 번호가 범위(1~9)밖에 있습니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String NUMBER_SIZE_OUT_OF_RANGE_MESSAGE = "야구 번호는 최대 3자리까지 입력할 수 있습니다.";
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
    public static final String FINISH_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEXT_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String NOT_PROPER_INPUT_MESSAGE = "1 또는 2만 입력할 수 있습니다.";
}