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

    @Test
    @DisplayName("숫자와 그 위치가 같은 개수를 센다")
    void count_digit_and_position_matches() {
        ThreeDigits digits = new ThreeDigits(List.of(4, 2, 5));
        ThreeDigits otherDigits = new ThreeDigits(List.of(4, 5, 6));

        assertThat(digits.countPositionMatches(otherDigits)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자만 같고 위치는 다른 숫자의 개수를 센다")
    void count_digit_only_matches() {
        ThreeDigits digits = new ThreeDigits(List.of(4, 2, 5));
        ThreeDigits otherDigits = new ThreeDigits(List.of(4, 5, 6));

        assertThat(digits.countDigitMatches(otherDigits)).isEqualTo(1);
    }
}
