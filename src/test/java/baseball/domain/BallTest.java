package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    @DisplayName("1 이하 숫자는 예외를 발생시킨다")
    void minRangeTest() {
        assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이 숫자를 입력해주세요");
    }

    @Test
    @DisplayName("9 이상의 숫자는 예외를 발생시킨다")
    void maxRangeTest() {
        assertThatThrownBy(() -> new Ball(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이 숫자를 입력해주세요");
    }

    @Test
    @DisplayName("숫자가 같은 Ball은 같다.")
    void equalTest() {
        Ball first = new Ball(1);
        Ball second = new Ball(1);

        assertThat(first).isEqualTo(second);
    }
}