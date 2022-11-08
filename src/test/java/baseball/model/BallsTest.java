package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    Balls balls = new Balls(List.of(1,2,3));

    @Test
    void 볼_검사() {
        assertThat(balls.isBall(0,2)).isTrue();
    }

    @Test
    void 스트라이크_검사() {
        assertThat(balls.isStrike(0,1)).isTrue();
    }
}
