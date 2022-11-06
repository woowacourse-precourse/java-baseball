package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    @Test
    public void ballsTest() {
        Balls computerBalls = new Balls(List.of(1,2,3));
        assertThat(computerBalls.hasSameValue(new Ball(4))).isFalse();
    }
    @Test
    public void ballsTestFalse() {
        Balls computerBalls = new Balls(List.of(1,2,3));
        assertThat(computerBalls.hasSameValue(new Ball(3))).isTrue();
    }
    @Test
    public void ballsPlayTest() {
        Balls computerBalls = new Balls(List.of(1,2,3));
        Balls playerBalls = new Balls(List.of(2,3,4));
        computerBalls.play(playerBalls, new Ball(2))
    }
}
