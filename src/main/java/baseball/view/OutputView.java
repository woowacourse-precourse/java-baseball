package baseball.view;

import baseball.model.Hint;
import baseball.model.Score;

public class OutputView {
    private static final String START_GAME= "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL= "볼";
    private static final String STRIKE= "스트라이크";
    private static final String NOTHING= "낫싱";

    public static void printStart() {
        System.out.println(START_GAME);
    }

    public static void printBall (int ballCnt) {
        System.out.printf("%d" +BALL+"\n", ballCnt);
    }

    public static void printStrike (int strikeCnt) {
        System.out.printf("%d" +STRIKE+ "\n", strikeCnt);
    }

    public static void printBallAndStrike (int ballCnt, int strikeCnt) {
        System.out.printf("%d" +BALL, ballCnt);
        System.out.printf(" %d" +STRIKE+ "\n", strikeCnt);
    }

    public static void printNothing () {
        System.out.println(NOTHING);
    }

    public static void printGameClear() {
        System.out.println(GAME_CLEAR);
    }

    public static void printHint(Score score) {
        Hint hint = score.getScoreHint();

        if (hint.equals(Hint.NOTHING)) OutputView.printNothing();
        if (hint.equals(Hint.BALL_AND_STRIKE)) OutputView.printBallAndStrike(score.getBall(), score.getStrike());
        if (hint.equals(Hint.ONLY_BALL)) OutputView.printBall(score.getBall());
        if (hint.equals(Hint.ONLY_STRIKE)) OutputView.printStrike(score.getStrike());
    }
}
