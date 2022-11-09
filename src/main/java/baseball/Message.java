package baseball;

public class Message {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_CONTINUE_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getBallMessage() {
        return BALL_MESSAGE;
    }

    public static String getStrikeMessage() {
        return STRIKE_MESSAGE;
    }

    public static String getNothingMessage() {
        return NOTHING_MESSAGE;
    }

    public static String getGameStartMessage() {
        return GAME_START_MESSAGE;
    }

    public static String getGameEndMessage() {
        return GAME_END_MESSAGE;
    }

    public static String getGameContinueCheckMessage() {
        return GAME_CONTINUE_CHECK_MESSAGE;
    }

    public static String getInputNumberMessage() {
        return INPUT_NUMBER_MESSAGE;
    }


}
