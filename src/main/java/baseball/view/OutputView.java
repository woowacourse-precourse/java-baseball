package baseball.view;

public class OutputView {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String SPACE = " ";
    private static final String NOTHING = "낫싱";
    private static final String ENDING_BASEBALL_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int ZERO = 0;

    public static void printScore(int strikeCount, int ballCount) {
        if (strikeCount == ZERO && ballCount == ZERO) {
            System.out.println(NOTHING);
            return;
        }

        if (ballCount > ZERO) {
            System.out.print(ballCount + BALL + SPACE);
        }

        if (strikeCount > ZERO) {
            System.out.print(strikeCount + STRIKE);
        }
        System.out.println();
    }

    public static void printEndGame() {
        System.out.println(ENDING_BASEBALL_GAME_MESSAGE);
    }
}
