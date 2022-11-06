package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitTest {
    @DisplayName("Digit이 범위 안에서는 잘 생성됨")
    @Test
    void Digit_범위_안() {
        assertThat(Digit.from(0)).isEqualTo(Digit.ZERO);
        assertThat(Digit.from(1)).isEqualTo(Digit.ONE);
        assertThat(Digit.from(2)).isEqualTo(Digit.TWO);
        assertThat(Digit.from(3)).isEqualTo(Digit.THREE);
        assertThat(Digit.from(4)).isEqualTo(Digit.FOUR);
        assertThat(Digit.from(5)).isEqualTo(Digit.FIVE);
        assertThat(Digit.from(6)).isEqualTo(Digit.SIX);
        assertThat(Digit.from(7)).isEqualTo(Digit.SEVEN);
        assertThat(Digit.from(8)).isEqualTo(Digit.EIGHT);
        assertThat(Digit.from(9)).isEqualTo(Digit.NINE);
    }

    @DisplayName("Digit의 범위 바깥에서는 예외")
    @Test
    void Digit_범위_바깥() {
        assertThrows(IllegalArgumentException.class, () -> Digit.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Digit.from(10));
    }
}
