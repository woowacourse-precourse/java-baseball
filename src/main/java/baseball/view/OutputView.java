package baseball.view;

import static baseball.Constants.ALL_STRIKES;
import static baseball.Constants.BALL;
import static baseball.Constants.NOTTING;
import static baseball.Constants.STRIKE;
import static baseball.Constants.THREE;
import static baseball.Constants.ZERO;

import baseball.domain.Result;

public class OutputView {

    public static void roundOutput(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if (ballCount == ZERO && strikeCount == ZERO) {
            System.out.println(NOTTING);
            return;
        }

        if (strikeCount == THREE) {
            System.out.println(ALL_STRIKES);
            return;
        }

        if (ballCount == ZERO) {
            System.out.println(strikeCount + STRIKE);
            return;
        }

        if (strikeCount == ZERO) {
            System.out.println(ballCount + BALL);
            return;
        }

        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }
}
