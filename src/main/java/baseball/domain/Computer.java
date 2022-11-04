package baseball.domain;

import baseball.infrastructure.util.ComputerRandomNumberGenerator;
import java.util.List;

public class Computer {

    private Balls computerBalls;

    public Computer(List<Integer> balls) {
        computerBalls.from(balls);
    }

    private static Computer init() {
        return new Computer(ComputerRandomNumberGenerator.generate());
    }
}
