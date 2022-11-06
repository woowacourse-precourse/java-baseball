package baseball;

import static baseball.utils.Constants.BALL;
import static baseball.utils.Constants.NOTHING;
import static baseball.utils.Constants.SPACE;
import static baseball.utils.Constants.STRIKE;

import java.util.List;

public class BallAndStrike {
    private final int ball;
    private final int strike;

    private BallAndStrike(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BallAndStrike from(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int digit = 0; digit < computer.size(); digit++) {
            int computerNumber = computer.get(digit);
            int playerNumber = player.get(digit);

            if (computerNumber == playerNumber) {
                strikeCount++;
                continue;
            }

            if (computer.contains(playerNumber)) {
                ballCount++;
            }
        }

        return new BallAndStrike(ballCount, strikeCount);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return NOTHING;
        }
        if (ball >= 1 && strike >= 1) {
            return ball + BALL + SPACE + strike + STRIKE;
        }
        if (ball >= 1) {
            return ball + BALL;
        }
        return strike + STRIKE;
    }
}
