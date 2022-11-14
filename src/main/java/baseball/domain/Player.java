package baseball.domain;

import baseball.utils.CustomNumberGenerator;

public class Player {

    private final CustomNumberGenerator customNumberGenerator = new CustomNumberGenerator();
    private Balls balls;

    public Balls createBalls() {
        this.balls = new Balls(customNumberGenerator.generate());

        return this.balls;
    }
}
