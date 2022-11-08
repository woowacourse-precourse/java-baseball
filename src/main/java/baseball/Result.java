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
}
