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
        int strikeCount = reportList.get(STRIKE_INDEX);
        int ballCount = reportList.get(BALL_INDEX);
        int nothingCount = reportList.get(NOTHING_INDEX);

        if (nothingCount == MAX_COUNT) {
            System.out.println(NOTHING);
        }

        if (ballCount != ZERO_COUNT) {
            System.out.print(ballCount + BALL);
        }

        if (strikeCount != ZERO_COUNT) {
            System.out.println(strikeCount + STRIKE);
        }
    }
}
