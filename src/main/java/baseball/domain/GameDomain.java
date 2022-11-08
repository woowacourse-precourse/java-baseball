package baseball.domain;

public class GameDomain {
    int strike;
    int ball;
    int[] gameNumbers;

    public GameDomain(int[] numbers) {
        gameNumbers = numbers;
    }

    public int[] gameNumbers() {
        return gameNumbers;
    }

    public void initScore() {
        strike = 0;
        ball = 0;
    }

    public int getStrikeScore() {
        return strike;
    }

    public int getBallScore() {
        return ball;
    }
}
