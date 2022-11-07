package baseball.view;

public class Output {
    private final static String NEW_LINE = "\n";
    private final static String SPACE = " ";
    private final static String BALL_FORMAT = "%d볼";
    private final static String STRIKE_FORMAT = "%d스트라이크";
    private final static String NOTHING = "낫싱";
    private final static String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            String ballAndStrike = String.join(SPACE, new String[]{BALL_FORMAT, STRIKE_FORMAT});
            System.out.printf(ballAndStrike + NEW_LINE, ballCount, strikeCount);
            return;
        }
        if (ballCount != 0) {
            System.out.printf(BALL_FORMAT + NEW_LINE, ballCount);
            return;
        }
        if (strikeCount != 0) {
            System.out.printf(STRIKE_FORMAT + NEW_LINE, strikeCount);
            return;
        }
        System.out.println(NOTHING);
    }

    public static void printGameClear() {
        System.out.println(GAME_CLEAR);
    }
}
