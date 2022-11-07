package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("Balls가 생성된다.")
    @Test
    void createBalls() {
        Balls balls = new Balls("123");
        Assertions.assertThat(balls.getBalls())
                .containsExactly(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3));
    }

    @DisplayName("중복된 값일 경우 예외가 발생한다.")
    @Test
    void validateDuplicateBalls() {
        assertThatThrownBy(() -> {
            new Balls("112");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 개수가 맞지 않으면 예외가 발생한다.")
    @Test
    void validateBallsSize() {
        assertThatThrownBy(() -> {
            new Balls("12");
            new Balls("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}