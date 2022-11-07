package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    @DisplayName("Ball 객체 생성 테스트")
    void create() {
        int number = 1;
        int position = 1;
        Ball ball = Ball.of(Number.from(number), Position.from(position));
        assertThat(ball.number()).as("정상 숫자 값").isEqualTo(number);
        assertThat(ball.position()).as("정상 위치 값").isEqualTo(position);
    }
}
