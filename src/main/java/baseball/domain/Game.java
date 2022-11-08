package baseball.domain;

public class Game {
    private static int ballCount;
    private static int strikeCount;

    public void initializeGame() {
        ballCount = 0;
        strikeCount = 0;
    }

    public static int getBallCount() {
        return ballCount;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public static void setBallCount(int count) {
        ballCount += count;
    }

    public static void setStrikeCount(int count) {
        strikeCount += count;
    }
}
