package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.ExceptionType;
import baseball.utils.ValidationNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationNumberTest {

    @Test
    void 숫자인지_확인_예외_발생() {
        String input = "14r";

        ValidationNumber validationNumber = new ValidationNumber();
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_NUMBER.getMessage());
    }

    @Test
    void 숫자_0_가지고_있는지_확인_예외_발생() {
        String input = "409";

        ValidationNumber validationNumber = new ValidationNumber();
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_ZERO.getMessage());
    }

    @Test
    void 중복되는_값_있는지_확인_예외_발생() {
        String input = "112";

        ValidationNumber validationNumber = new ValidationNumber();
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_OVERLAP.getMessage());
    }

    @Test
    void 주어진_크기와_동일한지_확인_예외_발생() {
        String input = "28";

        ValidationNumber validationNumber = new ValidationNumber();
        assertThatThrownBy(() -> validationNumber.checkTotalAndConvertIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.INVALID_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "12", "0", "re", "n2w" })
    void 종료_혹은_재시작_수가_아닐_경우_예외_발생(String input) {
        ValidationNumber validationNumber = new ValidationNumber();
        assertThatThrownBy(() -> validationNumber.checkEndOrRestartNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.INVALID_NUMBER_END_OR_RESTART.getMessage());
    }
}
