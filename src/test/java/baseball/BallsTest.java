package baseball;
import baseball.domain.Ball;
import baseball.domain.Balls;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    public void 공_여러개_생성_테스트() throws Exception {
        Ball ball = Ball.of(1,1);
        Ball ball2 = Ball.of(2,2);
        Ball ball3 = Ball.of(3,3);
        Balls balls = Balls.of(List.of(ball,ball2,ball3));

        assertThat(balls.size()).isEqualTo(3);
    }

}
