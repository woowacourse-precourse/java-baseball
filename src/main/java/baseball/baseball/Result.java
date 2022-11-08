package baseball.baseball;

import java.util.StringJoiner;

import static baseball.baseball.Digits.DIGIT_COUNT;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean isComplete() {
        return strikeCount == DIGIT_COUNT && ballCount == 0;
    }

    @Override
    public String toString() {
        if (isNothing()) return "낫싱";

        StringJoiner resultJoiner = new StringJoiner(" ");
        if (ballCount > 0) resultJoiner.add(ballCount + "볼");
        if (strikeCount > 0) resultJoiner.add(strikeCount + "스트라이크");

        return resultJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (strikeCount != result.strikeCount) return false;
        return ballCount == result.ballCount;
    }

    @Override
    public int hashCode() {
        int result = strikeCount;
        result = 31 * result + ballCount;
        return result;
    }
}
