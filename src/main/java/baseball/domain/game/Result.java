package baseball.domain.game;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String DELIMITER = " ";

    private final List<String> resultMessage;
    private final int strike;
    private final int ball;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
        this.resultMessage = new ArrayList<>();
    }

    private void ball() {
        if (ball == 0) {
            return;
        }

        resultMessage.add(String.format(BALL, ball));
    }

    private void strike() {
        if (strike == 0) {
            return;
        }

        resultMessage.add(String.format(STRIKE, strike));
    }

    public boolean isFinish() {
        return strike == 3;
    }

    @Override
    public String toString() {
        ball();
        strike();
        if (resultMessage.isEmpty()) {
            return NOTHING;
        }
        return String.join(DELIMITER, resultMessage);
    }

}
