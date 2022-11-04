package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("숫자는 세 자리다")
    void numbers_have_length_of_three() {
        List<Integer> twoNumbers = List.of(1, 2);
        List<Integer> fourNumbers = List.of(1, 2, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(twoNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(fourNumbers));
    }

    @Test
    @DisplayName("숫자는 서로 달라야 한다")
    void every_number_is_different() {
        List<Integer> numbers = List.of(1, 2, 1);

        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(numbers));
    }
}
