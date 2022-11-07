package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ONLY_BALL_MESSAGE = "%d볼";
    private static final String ONLY_STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_STOP_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static String resultMessage;

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printAnswerInputGuideMessage() {
        System.out.print(ANSWER_INPUT_GUIDE_MESSAGE);
    }

    public static void setNothingMessage() {
        resultMessage = NOTHING_MESSAGE;
    }

    public static void setOnlyBallMessage(int ball) {
        resultMessage = String.format(ONLY_BALL_MESSAGE, ball);
    }

    public static void setOnlyStrikeMessage(int strike) {
        resultMessage = String.format(ONLY_STRIKE_MESSAGE, strike);
    }

    public static void setBallAndStrikeMessage(int ball, int strike) {
        resultMessage = String.format(BALL_AND_STRIKE_MESSAGE, ball, strike);
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printResult() {
        System.out.println(resultMessage);
    }

    public static void printRestartOrStopGuideMessage() {
        System.out.println(RESTART_OR_STOP_GUIDE_MESSAGE);
    }
}
