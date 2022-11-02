package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationNumberTest {

    private static final int SIZE = 3;

    @Test
    void 숫자인지_확인_예외_발생() {
        String input = "14r";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkIsNumberAndNotHaveZero(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0_가지고_있는지_확인_예외_발생() {
        String input = "409";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkIsNumberAndNotHaveZero(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되는_값_있는지_확인_예외_발생() {
        List<Integer> input = List.of(1, 1, 2);

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkOverlap(input, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진_크기와_동일한지_확인_예외_발생() {
        List<Integer> input = List.of(2, 8);

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkNumberSize(input, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
