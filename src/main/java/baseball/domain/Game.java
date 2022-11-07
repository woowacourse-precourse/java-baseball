package baseball.domain;

public class Game {
    public static int strikeCount;
    public  static int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }

    public void initBaseBall() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int[] getGameNumbers() {
        return gameNumbers;
    }

    public static void incStrikeCount() {
        strikeCount += 1;
    }

    public static void incBallCount() {
        ballCount += 1;
    }
}