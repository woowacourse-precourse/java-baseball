package baseball.hint;

public class Hint {

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

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
