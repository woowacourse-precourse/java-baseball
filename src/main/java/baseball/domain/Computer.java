package baseball.domain;

import baseball.utils.RandomNumberGenerator;

public class Computer {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private Balls balls;

    public Balls createBalls() {
        this.balls = new Balls(randomNumberGenerator.generate());

        return this.balls;
    }
}
