package baseball.Output;

public class Message {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String GAME_END_MESSAGE = "숫자 야구 게임을 종료합니다.\n";
    public static final String INPUT_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static final String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String BALL_MESSAGE_FORMAT = "%d볼\n";
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크\n";
    private static final String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d볼 %d스트라이크\n";
    public static final String USER_INPUT_FOR_HINT_ERROR_MESSAGE = "잘못된 숫자를 입력하였습니다. 프로그램을 종료합니다.";
    public static final String USER_INPUT_FOR_NEXT_GAME_ERROR_MESSAGE ="잘못된 값을 입력하셨습니다. 다시 입력해주세요.(게임 재시작은 1, 종료는 2) : ";

    public static String getNothingMessage()
    {
        return NOTHING_MESSAGE;
    }
    public static String getBallMessage(int ballCount)
    {
        return String.format(BALL_MESSAGE_FORMAT,ballCount);
    }

    public static String getStrikeMessage(int strikeCount)
    {
        return String.format(STRIKE_MESSAGE_FORMAT,strikeCount);
    }

    public static String getBallAndStrikeMessage(int ballCount,int strikeCount)
    {
        return String.format(BALL_AND_STRIKE_MESSAGE_FORMAT,ballCount,strikeCount);
    }


}
