package baseball;

public class OutputView {
    private static final String PRINT_BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private static final String PRINT_STRIKE_COUNT = "%d스트라이크\n";
    private static final String PRINT_BALL_COUNT = "%d볼\n";
    private static final String NOTHING = "낫싱\n";
    private static final String GAME_TERMINATE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private static final int STRIKE_NUMBER = 3;
    private static final int ZERO = 0;

    public static void printGameResult(int ballCount, int strikeCount) {
        if (strikeCount == STRIKE_NUMBER) {
            printThreeStrikeResult();
            return;
        }

        if (strikeCount > ZERO && ballCount > ZERO) {
            printBallAndStrikeResult(strikeCount, ballCount);
            return;
        }

        if (strikeCount > ZERO && ballCount == ZERO) {
            printStrikeResult(strikeCount);
            return;
        }

        if (strikeCount == ZERO && ballCount > ZERO) {
            printBallResult(ballCount);
            return;
        }

        if (strikeCount == ZERO && ballCount == ZERO) {
            printNothingResult();
        }
    }

    private static void printBallAndStrikeResult(int strikeCount, int ballCount) {
        System.out.printf(PRINT_BALL_AND_STRIKE, ballCount, strikeCount);
    }

    private static void printStrikeResult(int strikeCount) {
        System.out.printf(PRINT_STRIKE_COUNT, strikeCount);
    }

    private static void printBallResult(int ballCount) {
        System.out.printf(PRINT_BALL_COUNT, ballCount);
    }

    private static void printNothingResult() {
        System.out.print(NOTHING);
    }

    private static void printThreeStrikeResult() {
        System.out.printf(PRINT_STRIKE_COUNT, STRIKE_NUMBER);
        System.out.printf(GAME_TERMINATE, STRIKE_NUMBER);
    }
}
