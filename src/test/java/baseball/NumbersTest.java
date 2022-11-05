package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("숫자는 서로 달라야 한다")
    void every_number_is_different() {
        List<Integer> digits = List.of(1, 2, 1);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(digits));
    }

    @Test
    @DisplayName("숫자끼리 스트라이크를 셀 수 있다")
    void count_strikes_between_numbers() {
        Numbers numbers = new Numbers(List.of(4, 2, 5));
        Numbers numbers2 = new Numbers(List.of(4, 5, 6));

        assertThat(numbers.countStrikesWith(numbers2)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자끼리 볼을 셀 수 있다")
    void count_balls_between_numbers() {
        Numbers numbers = new Numbers(List.of(4, 2, 5));
        Numbers numbers2 = new Numbers(List.of(4, 5, 6));

        assertThat(numbers.countBallsWith(numbers2)).isEqualTo(1);
    }
}
