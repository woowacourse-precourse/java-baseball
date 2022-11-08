package baseball.game;

import baseball.game.number.Number;
import java.util.Objects;

public class GameResult {
    private final String BALL_STRING = "볼";
    private final String STRIKE_STRING = "스트라이크";
    private final String NOTHING_STRING = "낫싱";
    private final String BLANK = " ";
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String convertToString() {
        StringBuilder resultStringBuilder = new StringBuilder();
        boolean zeroBall = ballCount == 0;
        boolean zeroStrike = strikeCount == 0;
        boolean allStrike = strikeCount == Number.FULL_SIZE;
        if (!allStrike && !zeroBall) {
            resultStringBuilder.append(ballCount);
            resultStringBuilder.append(BALL_STRING);
            resultStringBuilder.append(BLANK);
        }
        if (!zeroStrike) {
            resultStringBuilder.append(strikeCount);
            resultStringBuilder.append(STRIKE_STRING);
        }
        if (zeroBall && zeroStrike) {
            resultStringBuilder.append(NOTHING_STRING);
        }
        return resultStringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }
}
