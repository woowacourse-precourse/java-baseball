package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    private final Balls balls = new Balls("123");

    @DisplayName("Balls가 생성된다.")
    @Test
    void createBalls() {
        Balls balls1 = new Balls("123");
        Balls balls2 = new Balls(List.of(1, 2, 3));
        assertThat(balls1.getBalls())
                .containsExactly(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3));
        assertThat(balls2.getBalls())
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

    @DisplayName("스트라이크 3개")
    @Test
    void strike_3() {
        Result result = balls.match(new Balls("123"));
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @DisplayName("스트라이크 1개 볼 2개")
    @Test
    void strike_1_ball_2() {
        Result result = balls.match(new Balls("132"));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @DisplayName("스트라이크 0개 볼 0개")
    @Test
    void nothing() {
        Result result = balls.match(new Balls("456"));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }
}
