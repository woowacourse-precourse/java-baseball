package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExclusiveDigitsTest {

    @Test
    @DisplayName("숫자는 서로 달라야 한다")
    void every_number_is_different() {
        List<Integer> digitsWithDuplicates = List.of(1, 2, 1);

        assertThatIllegalArgumentException().isThrownBy(() -> new ExclusiveDigits(digitsWithDuplicates));
    }

    @Test
    @DisplayName("숫자와 그 위치가 같은 개수를 센다")
    void count_digit_and_position_matches() {
        ExclusiveDigits digits = new ExclusiveDigits(List.of(4, 2, 5));
        ExclusiveDigits otherDigits = new ExclusiveDigits(List.of(4, 5, 6));

        assertThat(digits.countPositionMatches(otherDigits)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자만 같고 위치는 다른 숫자의 개수를 센다")
    void count_digit_only_matches() {
        ExclusiveDigits digits = new ExclusiveDigits(List.of(4, 2, 5));
        ExclusiveDigits otherDigits = new ExclusiveDigits(List.of(4, 5, 6));

        assertThat(digits.countDigitMatches(otherDigits)).isEqualTo(1);
    }
}
