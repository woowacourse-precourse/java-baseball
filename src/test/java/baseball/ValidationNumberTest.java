package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidationNumberTest {

    private static final int SIZE = 3;

    @Test
    void 숫자인지_확인_예외_발생() {
        String input = "14r";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0_가지고_있는지_확인_예외_발생() {
        String input = "409";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되는_값_있는지_확인_예외_발생() {
        String input = "112";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진_크기와_동일한지_확인_예외_발생() {
        String input = "28";

        ValidationNumber validationNumber = new ValidationNumber(SIZE);
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
