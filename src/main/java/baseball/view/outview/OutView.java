package baseball.view.outview;

import java.util.List;

public class OutView {

    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    public static final int NOTHING_INDEX = 2;
    public static final int MAX_COUNT = 3;
    public static final int ZERO_COUNT = 0;
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";

    public static void print(List<Integer> reportList) {
        printNothing(reportList);
        printBall(reportList);
        printStrike(reportList);
    }

    private static void printNothing(List<Integer> reportList) {
        int nothingCount = reportList.get(NOTHING_INDEX);
        printNothing(nothingCount);
    }

    private static void printNothing(int nothingCount) {
        if (nothingCount == MAX_COUNT) {
            System.out.println(NOTHING);
        }
    }

    private static void printBall(List<Integer> reportList) {
        int ballCount = reportList.get(BALL_INDEX);
        printBall(ballCount);
    }

    private static void printBall(int ballCount) {
        if (ballCount != ZERO_COUNT) {
            System.out.print(ballCount + BALL);
        }
    }

    private static void printStrike(List<Integer> reportList) {
        int strikeCount = reportList.get(STRIKE_INDEX);
        printStrike(strikeCount);
    }

    private static void printStrike(int strikeCount) {
        if (strikeCount != ZERO_COUNT) {
            System.out.println(strikeCount + STRIKE);
        }
    }
}
