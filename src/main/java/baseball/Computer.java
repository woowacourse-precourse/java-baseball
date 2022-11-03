package baseball;

import baseball.utils.RandomNumberGenerator;

public class Computer {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private Balls balls;

    public void createBalls() {
        this.balls = new Balls(randomNumberGenerator.generate());
    }

    public Balls getBalls() {
        return balls;
    }
}
