package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 이미_있는_숫자와_겹치는지_확인하는_기능() {
        Balls balls = new Balls();
        balls.addBall(new Ball(1));

        assertThat(balls.checkDuplicate(new Ball(1))).isTrue();
        assertThat(balls.checkDuplicate(new Ball(2))).isFalse();
    }
}
