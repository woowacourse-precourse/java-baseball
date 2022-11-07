package baseball.view;

import baseball.model.Score;

public class OutputView {

    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static void printResultMessage(Score score) {
        String resultMessage = score.makeResultMessage(BALL_MESSAGE, STRIKE_MESSAGE, NOTHING_MESSAGE);
        System.out.println(resultMessage);
    }
}
