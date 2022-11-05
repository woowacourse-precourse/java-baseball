package baseball;

import baseball.utils.CustomNumberGenerator;

public class Player {

    private final CustomNumberGenerator customNumberGenerator = new CustomNumberGenerator();
    private Balls balls;

    public void createBalls() {
        this.balls = new Balls(customNumberGenerator.generate());
    }

    public Balls getBalls() {
        return balls;
    }
}
