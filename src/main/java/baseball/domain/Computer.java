package baseball.domain;

import baseball.infrastructure.util.ComputerRandomNumberGenerator;
import java.util.List;

public class Computer {

    private Balls computerBalls;

    private Computer(List<Integer> balls) {
        computerBalls.from(balls);
    }

    public static Computer init() {
        return new Computer(ComputerRandomNumberGenerator.generate());
    }
}
