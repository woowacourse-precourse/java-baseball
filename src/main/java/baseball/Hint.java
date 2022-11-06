package baseball;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.NOTHING;
import static baseball.constant.Hint.STRIKE;

public class Hint {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0) {
            stringBuilder.append(ball).append(BALL);
        }
        if (strike > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike).append(STRIKE);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(NOTHING);
        }
        return stringBuilder.toString();
    }

    public static HintBuilder builder() {
        return new HintBuilder();
    }

    public static class HintBuilder {

        private Hint hint = new Hint();

        public HintBuilder strike(int strike) {
            hint.strike = strike;
            return this;
        }

        public HintBuilder ball(int ball) {
            hint.ball = ball;
            return this;
        }

        public Hint build() {
            return hint;
        }
    }

}
