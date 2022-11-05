package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreeDigitsTest {

    @Test
    @DisplayName("숫자는 세 자리다")
    void digits_are_length_of_three() {
        List<Integer> twoDigits = List.of(1, 2);
        List<Integer> fourDigits = List.of(1, 2, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> new ThreeDigits(twoDigits));
        assertThatIllegalArgumentException().isThrownBy(() -> new ThreeDigits(fourDigits));
    }
}
