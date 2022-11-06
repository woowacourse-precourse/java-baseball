package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallTest {
    @DisplayName("Ball이 범위 안에서는 문제 없이 생성됨")
    @Test
    void Ball_범위_안() {
        assertThat(Ball.from(0)).isEqualTo(Ball.ZERO);
        assertThat(Ball.from(1)).isEqualTo(Ball.ONE);
        assertThat(Ball.from(2)).isEqualTo(Ball.TWO);
        assertThat(Ball.from(3)).isEqualTo(Ball.THREE);
    }

    @DisplayName("Ball에 숫자 범위가 바깥 것이 들어오면 예외 발생")
    @Test
    void Ball_범위_바깥() {
        assertThrows(IllegalArgumentException.class, () -> Ball.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Ball.from(4));
    }
}
