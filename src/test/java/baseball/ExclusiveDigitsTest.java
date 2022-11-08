package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Digit;
import baseball.domain.ExclusiveDigits;
import baseball.domain.PositiveDigit;

public class ExclusiveDigitsTest {

    @Test
    @DisplayName("숫자는 서로 달라야 한다")
    void every_number_is_different() {
        List<Digit> digitsWithDuplicates = positiveDigitsOf(1, 2, 1);

        assertThatIllegalArgumentException().isThrownBy(() -> new ExclusiveDigits<>(digitsWithDuplicates));
    }

    @Test
    @DisplayName("숫자와 그 위치가 같은 개수를 센다")
    void count_digit_and_position_matches() {
        ExclusiveDigits<Digit> digits = new ExclusiveDigits<>(positiveDigitsOf(4, 2, 5));
        ExclusiveDigits<Digit> otherDigits = new ExclusiveDigits<>(positiveDigitsOf(4, 5, 6));

        assertThat(digits.countPositionMatches(otherDigits)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자만 같고 위치는 다른 숫자의 개수를 센다")
    void count_digit_only_matches() {
        ExclusiveDigits<Digit> digits = new ExclusiveDigits<>(positiveDigitsOf(4, 2, 5));
        ExclusiveDigits<Digit> otherDigits = new ExclusiveDigits<>(positiveDigitsOf(4, 5, 6));

        assertThat(digits.countDigitMatches(otherDigits)).isEqualTo(1);
    }

    private List<Digit> positiveDigitsOf(Integer... digits) {
        return Arrays.stream(digits)
                .map(PositiveDigit::new)
                .collect(Collectors.toList());
    }
}
