package baseball.domain;

import java.util.List;

public class Computer {

    private final Balls comBalls;

    public Computer(Balls comBalls) {
        this.comBalls = comBalls;
    }

    public Ball getBallNumber(int index) {
        return comBalls.getBall(index);
    }
}
