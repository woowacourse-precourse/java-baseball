package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

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
}
