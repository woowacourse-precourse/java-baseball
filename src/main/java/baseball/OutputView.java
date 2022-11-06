package baseball;

public class OutputView {
    private static final String PRINT_BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private static final String PRINT_STRIKE_COUNT = "%d스트라이크\n";
    private static final String PRINT_BALL_COUNT = "%d볼\n";
    private static final String NOTHING = "낫싱\n";
    private static final String GAME_TERMINATE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private static final int STRIKE_NUMBER = 3;
    private static final int ZERO = 0;

    public static boolean printGameResult(int ballCount, int strikeCount) {
        if (strikeCount == STRIKE_NUMBER) {
            return printThreeStrikeResult();
        }

        if (strikeCount > ZERO && ballCount > ZERO) {
            return printBallAndStrikeResult(strikeCount, ballCount);
        }

        if (strikeCount > ZERO && ballCount == ZERO) {
            return printStrikeResult(strikeCount);
        }

        if (strikeCount == ZERO && ballCount > ZERO) {
            return printBallResult(ballCount);
        }

        if (strikeCount == ZERO && ballCount == ZERO) {
            return printNothingResult();
        }

        return true;
    }

    private static boolean printBallAndStrikeResult(int strikeCount, int ballCount) {
        System.out.printf(PRINT_BALL_AND_STRIKE, ballCount, strikeCount);

        return true;
    }

    private static boolean printStrikeResult(int strikeCount) {
        System.out.printf(PRINT_STRIKE_COUNT, strikeCount);

        return true;
    }

    private static boolean printBallResult(int ballCount) {
        System.out.printf(PRINT_BALL_COUNT, ballCount);

        return true;
    }

    private static boolean printNothingResult() {
        System.out.print(NOTHING);

        return true;
    }

    private static boolean printThreeStrikeResult() {
        System.out.printf(PRINT_STRIKE_COUNT, STRIKE_NUMBER);
        System.out.printf(GAME_TERMINATE, STRIKE_NUMBER);

        return false;
    }
}
