package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Numbers;

public class NumbersTest {

    @Test
    @DisplayName("숫자가 세 개가 아니면 예외를 던진다")
    void exception_on_digits_length_is_not_three() {
        List<Integer> twoDigits = List.of(1, 2);
        List<Integer> fourDigits = List.of(1, 2, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromIntegers(twoDigits));
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromIntegers(fourDigits));
    }

    @Test
    @DisplayName("숫자는 세 자리다")
    void digits_length_is_three() {
        List<Integer> threeDigits = List.of(1, 2, 3);

        assertThatNoException().isThrownBy(() -> Numbers.fromIntegers(threeDigits));
    }

    @Test
    @DisplayName("숫자끼리 스트라이크를 셀 수 있다")
    void count_strikes_between_numbers() {
        Numbers numbers = numbersFrom(4, 2, 5);
        Numbers numbers2 = numbersFrom(4, 5, 6);

        assertThat(numbers.countStrikesWith(numbers2)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자끼리 볼을 셀 수 있다")
    void count_balls_between_numbers() {
        Numbers numbers = numbersFrom(4, 2, 5);
        Numbers numbers2 = numbersFrom(4, 5, 6);

        assertThat(numbers.countBallsWith(numbers2)).isEqualTo(1);
    }

    private Numbers numbersFrom(Integer... integers) {
        return Numbers.fromIntegers(List.of(integers));
    }
}
