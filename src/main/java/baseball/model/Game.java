package baseball.model;

public class Game {
    int strikeCount;
    int ballCount;
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

    public void plusStrikeCount() {
        strikeCount += 1;
    }

    public void plusBallCount() {
        ballCount += 1;
    }
}
