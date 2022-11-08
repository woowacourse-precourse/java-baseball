package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
        }
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + STRIKE);
        }
        if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + BALL);
        }
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + BALL + SPACE + strikeCount + STRIKE);
        }
    }

    public static void printVictoryMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
