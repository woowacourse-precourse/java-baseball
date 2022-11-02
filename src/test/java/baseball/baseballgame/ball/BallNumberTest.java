package baseball.baseballgame.ball;

import static baseball.baseballgame.ball.BallNumber.MAX_RANGE;
import static baseball.baseballgame.ball.BallNumber.MIN_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallNumberTest {

    @Test
    void ball_number_range() {
        assertThatThrownBy(() -> BallNumber.createBallNumber(10)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼넘버는 " + MIN_RANGE + "이상" + MAX_RANGE + "이하의 숫자여야 합니다.");
        assertThatThrownBy(() -> BallNumber.createBallNumber(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼넘버는 " + MIN_RANGE + "이상" + MAX_RANGE + "이하의 숫자여야 합니다.");

        assertThatCode(() -> BallNumber.createBallNumber(9)).doesNotThrowAnyException();
    }

    @Test
    void equals() {
        BallNumber ballNumber = new BallNumber(3);
        assertThat(new BallNumber(3)).isEqualTo(ballNumber);

        assertThat(new BallNumber(4)).isNotEqualTo(ballNumber);
    }
}
