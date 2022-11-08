package baseball.domain;

public class GameDomain {
    int strike;
    int ball;
    int[] gameNumbers;

    public GameDomain(int[] numbers) {
        gameNumbers = numbers;
    }

    public void initScore() {
        strike = 0;
        ball = 0;
    }
}
