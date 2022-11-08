package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SPACE_DELIMITER = " ";
    private static final String NO_MESSAGE = "";

    public static void startGame() {
        System.out.println(START_MESSAGE);
    }

    public static void printStrikeAndBall(int strike, int ball) {
        String result = String.join(SPACE_DELIMITER, getBallMessage(ball), getStrikeMessage(strike));
        System.out.println(result.trim());
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return NO_MESSAGE;
        }
        return String.format(STRIKE_MESSAGE, strike);
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return NO_MESSAGE;
        }
        return String.format(BALL_MESSAGE, ball);
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printFinish() {
        System.out.println(END_MESSAGE);
    }
}
