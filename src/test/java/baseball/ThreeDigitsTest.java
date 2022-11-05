package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreeDigitsTest {

    @Test
    @DisplayName("세 자리가 아니면 예외를 던진다")
    void exception_on_digits_length_is_three() {
        List<Integer> twoDigits = List.of(1, 2);
        List<Integer> fourDigits = List.of(1, 2, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> new ThreeDigits(twoDigits));
        assertThatIllegalArgumentException().isThrownBy(() -> new ThreeDigits(fourDigits));
    }

    @Test
    @DisplayName("숫자는 세 자리다")
    void digits_length_is_three() {
        List<Integer> threeDigits = List.of(1, 2, 3);

        assertThatNoException().isThrownBy(() -> new ThreeDigits(threeDigits));
    }
}
