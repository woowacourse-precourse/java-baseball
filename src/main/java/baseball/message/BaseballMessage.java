package baseball.message;

public class BaseballMessage {
    private BaseballMessage() { }

    public static String WELCOME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String STRIKE_MESSAGE = "%d스트라이크";
    public static String BALL_MESSAGE = "%d볼";
    public static String STRIKE_AND_BALL_MESSAGE = "%d볼 %d스트라이크";
    public static String NOTHING_MESSAGE = "낫싱";

    public static String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String STRIKE_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

}
