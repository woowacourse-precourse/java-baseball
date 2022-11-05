package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveDigitTest {

    @Test
    @DisplayName("1과 9사이가 아닌 숫자는 예외를 던진다")
    void exception_on_not_between_one_and_nine() {
        assertThatIllegalArgumentException().isThrownBy(() -> new PositiveDigit(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new PositiveDigit(10));
    }
}
