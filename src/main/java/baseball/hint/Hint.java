package baseball.hint;

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
