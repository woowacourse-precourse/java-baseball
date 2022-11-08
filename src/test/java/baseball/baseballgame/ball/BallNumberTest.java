package baseball.baseballgame.ball;

import static baseball.model.ball.BallNumber.BALL_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.ball.BallNumber;
import org.junit.jupiter.api.Test;

public class BallNumberTest {

    @Test
    void ball_number_range() {
        assertThatThrownBy(() -> BallNumber.createBallNumber(10)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALL_NUMBER_ERROR);
        assertThatThrownBy(() -> BallNumber.createBallNumber(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BALL_NUMBER_ERROR);

        assertThatCode(() -> BallNumber.createBallNumber(9)).doesNotThrowAnyException();
    }

    @Test
    void equals() {
        BallNumber ballNumber = new BallNumber(3);
        assertThat(new BallNumber(3)).isEqualTo(ballNumber);
        assertThat(new BallNumber(4)).isNotEqualTo(ballNumber);
    }
}
