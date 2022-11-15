package baseball.game;

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
        if (ballExists()) {
            appendBallCount(resultStringBuilder);
        }
        if (strikeExists()) {
            appendStrikeCount(resultStringBuilder);
        }
        if (neitherBallNorStrike()) {
            resultStringBuilder.append(NOTHING_STRING);
        }
        return resultStringBuilder.toString();
    }

    private boolean strikeExists() {
        return strikeCount != 0;
    }

    private boolean ballExists() {
        return ballCount != 0;
    }

    private boolean neitherBallNorStrike() {
        return (ballCount == 0) && (strikeCount == 0);
    }

    private void appendStrikeCount(StringBuilder resultStringBuilder) {
        resultStringBuilder.append(strikeCount);
        resultStringBuilder.append(STRIKE_STRING);
    }

    private void appendBallCount(StringBuilder resultStringBuilder) {
        resultStringBuilder.append(ballCount);
        resultStringBuilder.append(BALL_STRING);
        resultStringBuilder.append(BLANK);
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
