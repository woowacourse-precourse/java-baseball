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
        boolean ballExists = ballCount != 0;
        boolean strikeExists = strikeCount != 0;
        if (ballExists) {
            resultStringBuilder.append(ballCount);
            resultStringBuilder.append(BALL_STRING);
            resultStringBuilder.append(BLANK);
        }
        if (strikeExists) {
            resultStringBuilder.append(strikeCount);
            resultStringBuilder.append(STRIKE_STRING);
        }
        if (!ballExists && !strikeExists) {
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
