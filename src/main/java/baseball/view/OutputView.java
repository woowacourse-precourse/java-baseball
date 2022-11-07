package baseball.view;

import static baseball.Constants.ALL_STRIKES;
import static baseball.Constants.BALL;
import static baseball.Constants.NOTTING;
import static baseball.Constants.STRIKE;
import static baseball.Constants.THREE;
import static baseball.Constants.ZERO;

import baseball.domain.Result;

public class OutputView {

    public static String roundOutput(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if (ballCount == ZERO && strikeCount == ZERO) {
            return NOTTING;
        }

        if (strikeCount == THREE) {
            return ALL_STRIKES;
        }

        if (ballCount == ZERO) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == ZERO) {
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }
}
