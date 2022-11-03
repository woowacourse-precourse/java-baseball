package baseball.model;

public class Umpire {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private final int ball;
    private final int strike;
    private final boolean nothing;

    public Umpire(int ball, int strike, boolean nothing) {
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
    }

    public Umpire(int ball, int strike) {
        this(ball, strike, (ball == 0 && strike == 0));
    }

    public String decision() {
        StringBuilder gameResult = new StringBuilder();
        if (ball > 0) {
            gameResult.append(ball).append(BALL).append(" ");
        }
        if (strike > 0) {
            gameResult.append(strike).append(STRIKE).append(" ");
        }
        if (nothing) {
            gameResult.append(NOTHING).append(" ");
        }
        gameResult.deleteCharAt(gameResult.length() - 1);

        return gameResult.toString();
    }
}
