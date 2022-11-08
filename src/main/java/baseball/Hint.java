package baseball;

public class Hint {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void addStrikeCount() {
        strikeCount += 1;
    }

    public void addBallCount() {
        ballCount += 1;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public String toStringBallCount() {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + "볼";
    }

    public String toStringStrikeCount() {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + "스트라이크";
    }

    public boolean isNothing() {
        return strikeCount + ballCount == 0;
    }
}
