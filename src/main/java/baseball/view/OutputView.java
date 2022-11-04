package baseball.view;

public class OutputView {


    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int THREE_STRIKE_COUNT = 3;
    private static final String THREE_STRIKE_MESSAGE = "3스트라이크";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int ZERO_VALUE = 0;
    private static final String NOTHING_RESULT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == THREE_STRIKE_COUNT) {
            System.out.println(THREE_STRIKE_MESSAGE);
            System.out.println(GAME_END_MESSAGE);
            System.out.println(GAME_RESTART_OR_END_MESSAGE);
        }
        if (strikeCount == ZERO_VALUE && ballCount == ZERO_VALUE) {
            System.out.println(NOTHING_RESULT_MESSAGE);
        }
        if (strikeCount != ZERO_VALUE && ballCount != ZERO_VALUE) {
            System.out.println(ballCount + BALL_MESSAGE + strikeCount + STRIKE_MESSAGE);
        }
        if (strikeCount != ZERO_VALUE && strikeCount != THREE_STRIKE_COUNT && ballCount == ZERO_VALUE) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
        }
        if (ballCount != ZERO_VALUE && strikeCount == ZERO_VALUE) {
            System.out.println(ballCount + BALL_MESSAGE);
        }
    }
}
