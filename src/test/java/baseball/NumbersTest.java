package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("숫자는 세 자리다")
    void numbers_have_length_of_three() {
        List<Integer> twoDigits = List.of(1, 2);
        List<Integer> fourDigits = List.of(1, 2, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(twoDigits));
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(fourDigits));
    }

    @Test
    @DisplayName("각 숫자는 1과 9사이다")
    void every_number_is_between_one_to_nine() {
        List<Integer> digitsWithZero = List.of(0, 9, 2);
        List<Integer> digitsWithTen = List.of(1, 2, 10);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(digitsWithZero));
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(digitsWithTen));
    }

    @Test
    @DisplayName("숫자는 서로 달라야 한다")
    void every_number_is_different() {
        List<Integer> digits = List.of(1, 2, 1);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(digits));
    }

    @Test
    @DisplayName("숫자를 비교할 수 있다")
    void compare_numbers() {
        Numbers numbers = new Numbers(List.of(4, 2, 5));
        Numbers numbers2 = new Numbers(List.of(4, 5, 6));

        assertThat(numbers.compareStrikes(numbers2)).isEqualTo(1);
        assertThat(numbers.compareBalls(numbers2)).isEqualTo(1);
    }
}
