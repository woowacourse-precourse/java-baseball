package baseball.Output;

public class Message {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String GAME_END_MESSAGE = "숫자 야구 게임을 종료합니다.\n";
    public static final String INPUT_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static final String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String BALL_MESSAGE_FORMAT = "%d ball\n";
    private static final String STRIKE_MESSAGE_FORMAT = "%d strike\n";
    private static final String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d ball %d strike\n";

    public static String getNothingMessage()
    {
        return NOTHING_MESSAGE;
    }
    public static String getBallMessage(int ballCount)
    {
        return String.format(Message.BALL_MESSAGE_FORMAT,ballCount);
    }

    public static String getStrikeMessage(int strikeCount)
    {
        return String.format(Message.STRIKE_MESSAGE_FORMAT,strikeCount);
    }

    public static String getBallAndStrikeMessage(int ballCount,int strikeCount)
    {
        return String.format(Message.BALL_AND_STRIKE_MESSAGE_FORMAT,ballCount,strikeCount);
    }

}
