package baseball.view;

public class ResultView {
    public static final String GAME_QUIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRING_FORMAT = "%d%s";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";

    public static void resultPrint(int strike, int ball) {
        ballInfo(ball);
        strikeInfo(strike);
        nothingInfo(strike, ball);
        System.out.println();
    }

    private static void strikeInfo(int strike) {
        if (strike != 0) {
            System.out.printf(STRING_FORMAT, strike, STRIKE);
        }
    }

    private static void ballInfo(int ball) {
        if (ball != 0) {
            System.out.printf(STRING_FORMAT, ball, BALL);
        }
    }

    private static void nothingInfo(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.print(NOTHING);
        }
    }

    public static void endGameMessage() {
        System.out.println(GAME_QUIT);
    }
}
