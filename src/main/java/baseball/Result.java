package baseball;

public class Result {
    private static String BALL_WORD = "볼";
    private static String STRIKE_WORD = "스트라이크";
    private static String NOTHING_WORD = "낫싱";

    private final int ball;
    private final int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result compare(BallCollection computerNumbers, BallCollection playerNumbers) {
        int computerNumber;
        int playerNumber;
        int ball = 0;
        int strike = 0;

        for (int index = 0; index < BallCollection.BALL_COUNT; index++) {
            computerNumber = computerNumbers.get(index);
            playerNumber = playerNumbers.get(index);

            if (computerNumber == playerNumber) {
                strike++;
                continue;
            }
            if (computerNumbers.contains(playerNumber)) {
                ball++;
            }
        }

        return new Result(ball, strike);
    }

    public void printResult() {
        System.out.println(getMessage());
    }

    private String getMessage() {
        if (isNothing()) {
            return NOTHING_WORD;
        }
        if (isBall()) {
            return ball + BALL_WORD;
        }
        if (isStrike()) {
            return strike + STRIKE_WORD;
        }

        return ball + BALL_WORD + " " + strike + STRIKE_WORD;
    }

    private boolean isStrike() {
        return strike != 0 && ball == 0;
    }

    private boolean isBall() {
        return strike == 0 && ball != 0;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isAllStrike() {
        return strike == BallCollection.BALL_COUNT;
    }

    @Override
    public boolean equals(Object obj) {
        Result result = (Result) obj;
        return this.ball == result.ball && this.strike == result.strike;
    }
}
