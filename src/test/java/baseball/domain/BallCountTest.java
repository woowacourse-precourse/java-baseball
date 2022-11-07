package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallCountTest {
    @Test
    @DisplayName("스트라이크 0 미만시 IllegalArgumentException 발생")
    void 스트라이크_0미만_예외() {
        assertThatThrownBy(
            () -> new BallCount(-1, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("스트라이크 3 초과시 IllegalArgumentException 발생")
    void 스트라이크_3초과_예외() {
        assertThatThrownBy(
            () -> new BallCount(4, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 0 미만시 IllegalArgumentException 발생")
    void 볼_0미만_예외() {
        assertThatThrownBy(
            () -> new BallCount(2, -1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 3 초과시 IllegalArgumentException 발생")
    void 볼_3초과_예외() {
        assertThatThrownBy(
            () -> new BallCount(2, 4)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 0 스트라이크 0이면 낫싱 리턴")
    void 볼_0_스트라이크_0() {
        BallCount ballCount = new BallCount(0, 0);
        String result = ballCount.ballCountResult();
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼 1 스트라이크 0이면 1볼 리턴")
    void 볼_1_스트라이크_0() {
        BallCount ballCount = new BallCount(0, 1);
        String result = ballCount.ballCountResult();
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    @DisplayName("볼 0 스트라이크 1이면 1스트라이크 리턴")
    void 볼_0_스트라이크_1() {
        BallCount ballCount = new BallCount(1, 0);
        String result = ballCount.ballCountResult();
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("볼 1 스트라이크 1이면 1볼 1스트라이크 리턴")
    void 볼_1_스트라이크_1() {
        BallCount ballCount = new BallCount(1, 1);
        String result = ballCount.ballCountResult();
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }
}
