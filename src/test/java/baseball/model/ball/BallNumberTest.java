package baseball.model.ball;

import static baseball.model.ball.BallNumber.BALL_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallNumberTest {

    @Test
    void ball_number_range() {
        assertThatThrownBy(() -> new BallNumber(10)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALL_NUMBER_ERROR);
        assertThatThrownBy(() -> new BallNumber(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALL_NUMBER_ERROR);

        assertThatCode(() -> new BallNumber(9)).doesNotThrowAnyException();
    }

    @Test
    void equals() {
        BallNumber ballNumber = new BallNumber(3);
        assertThat(new BallNumber(3)).isEqualTo(ballNumber);
        assertThat(new BallNumber(4)).isNotEqualTo(ballNumber);
    }
}
