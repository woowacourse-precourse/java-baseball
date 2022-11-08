package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    private final Ball ball = new Ball(0, 1);

    @DisplayName("1~9사이의 숫자일 경우 Ball이 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "9"})
    void createBall(int input) {
        Ball ball = new Ball(0, input);
        assertThat(ball).isEqualTo(new Ball(0, input));
    }

    @DisplayName("1~9사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0", "10"})
    void validateBall(int input) {
        assertThatThrownBy(() -> {
            new Ball(0, input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자와 위치가 같을 경우 STRIKE이다.")
    @Test
    void strike() {
        assertThat(ball.match(new Ball(0, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("같은 수가 다른 자리에 있으면 볼이다.")
    @Test
    void ball() {
        assertThat(ball.match(new Ball(1, 1))).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("같은 수가 전혀 없으면 낫싱이다.")
    @Test
    void nothing() {
        assertThat(ball.match(new Ball(1, 2))).isEqualTo(BallStatus.NOTHING);
    }
}
