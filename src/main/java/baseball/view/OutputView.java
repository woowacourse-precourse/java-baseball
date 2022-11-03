package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printGameRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }

    public static void printBallAndStrike(int ballCnt, int strikeCnt) {
        if (isOnlyBall(ballCnt, strikeCnt)) {
            System.out.println(ballCnt + BALL);

        } else if (isOnlyStrike(ballCnt, strikeCnt)) {
            System.out.println(strikeCnt + STRIKE);

        } else if (isBothBallAndStrike(ballCnt, strikeCnt)) {
            System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);
        }
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    private static boolean isOnlyBall(int ballCnt, int strikeCnt) {
        return ballCnt != 0 && strikeCnt == 0;
    }

    private static boolean isOnlyStrike(int ballCnt, int strikeCnt) {
        return ballCnt == 0 && strikeCnt != 0;
    }

    private static boolean isBothBallAndStrike(int ballCnt, int strikeCnt) {
        return ballCnt != 0 && strikeCnt != 0;
    }
}
