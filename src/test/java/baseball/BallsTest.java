package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.Ball;
import baseball.domain.Balls;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    List<Ball> balls = new ArrayList<>();

    @Test
    void checkMakeComputerBalls() {
        Balls comBalls = new Balls(balls).makeComputerBalls();
        assertEquals(comBalls.size(), 3);
    }
}
