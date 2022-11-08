package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleDigitTest {

    @Test
    @DisplayName("SingleDigit 유효성 검증")
    void validateSingleDigit() {
        Assertions.assertThatThrownBy(() -> new SingleDigit(0)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new SingleDigit(10)).isInstanceOf(IllegalArgumentException.class);

        for (int i = 1; i <= 9; i++) {
            new SingleDigit(i);
        }
    }

    @Test
    @DisplayName("SingleDigit 객체 간의 비교 검증")
    void validateEquals() {
        SingleDigit digit1 = new SingleDigit(1);
        SingleDigit digit2 = new SingleDigit(1);
        SingleDigit digit3 = new SingleDigit(3);

        Assertions.assertThat(digit1.equals(digit2)).isEqualTo(true);
        Assertions.assertThat(digit2.equals(digit3)).isEqualTo(false);
    }

}
