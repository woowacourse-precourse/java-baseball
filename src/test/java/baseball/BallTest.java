package baseball;

import static baseball.Const.WRONG_INPUT;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BallTest {

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

    @Test
    void 입력으로_들어온_숫자를_Ball_객체로_변환() {
        // given
        Ball ball = new Ball('1');

        // then
        assertThat(ball.getNumber()).isEqualTo(1);
    }

    @Test
    void 잘못된_입력이_들어온_경우_Exception_반환() {
        assertThatThrownBy(() -> new Ball('0'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_INPUT);
    }
}
