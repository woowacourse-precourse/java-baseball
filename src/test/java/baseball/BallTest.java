package baseball;

import baseball.Ball;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BallTest {

    @Test
    void Random으로_숫자_생성() {
        // given
        Ball ball = new Ball();
        ball.generate();

        // when
        boolean testResult = false;
        if (1 <= ball.getNumber() && ball.getNumber() <= 9) {
            testResult = true;
        }

        // then
        assertThat(testResult).isTrue();
    }
}
