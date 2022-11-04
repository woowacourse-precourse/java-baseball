package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @Test
    void 같은_숫자_같은_위치_스트라이크_확인하기() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, 0));
        balls.add(new Ball(3, 1));
        balls.add(new Ball(5, 2));


        Balls computer = new Balls(balls);


        assertThat(computer.hasStrike(new Ball(3, 1))).isTrue();
        assertThat(computer.hasStrike(new Ball(3, 2))).isFalse();
    }

    @Test
    void 같은_숫자_다른_위치_볼_확인하기() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, 0));
        balls.add(new Ball(3, 1));
        balls.add(new Ball(5, 2));


        Balls computer = new Balls(balls);


        assertThat(computer.hasBall(new Ball(3, 0))).isTrue();
        assertThat(computer.hasBall(new Ball(1, 0))).isFalse();
    }
}
