package baseball.domain;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(Baseball baseball, Numbers userNumbers) {
        this.strikeCount = baseball.countStrike(userNumbers);
        this.ballCount = baseball.countBall(userNumbers);
    }

    public String makeMessage() {
        Referee referee = Referee.ballCountToMessage(strikeCount, ballCount);
        if (strikeCount == 0 && ballCount == 0) {
            return referee.getMessage();
        }
        if (strikeCount != 0 && ballCount != 0) {
            return String.format(referee.getMessage(), ballCount, strikeCount);
        }
        if (strikeCount != 0) {
            return String.format(referee.getMessage(), strikeCount);
        }
        return String.format(referee.getMessage(), ballCount);
    }
}
