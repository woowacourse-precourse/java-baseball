package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    void 사용자입력_통과() {
        String input = "123";
        String input2 = "987";
        String input3 = "159";

        Assertions.assertThatNoException().isThrownBy(() -> NumberValidator.validate(input));
        Assertions.assertThatNoException().isThrownBy(() -> NumberValidator.validate(input2));
        Assertions.assertThatNoException().isThrownBy(() -> NumberValidator.validate(input3));
    }

    @Test
    void 사용자입력_예외_중복_발생() {
        String input = "112";

        assertException(input);
    }

    @Test
    void 사용자입력_예외_0_입력() {
        String input = "012";

        assertException(input);
    }

    @Test
    void 사용자입력_예외_3자리수_미만() {
        String input = "12";

        assertException(input);
    }

    @Test
    void 사용자입력_예외_3자리수_초과() {
        String input = "1234";

        assertException(input);
    }

    @Test
    void 사용자입력_예외_숫자가_아닌_입력() {
        String input = "12a";

        assertException(input);
    }

    private void assertException(String input) {
        Assertions.assertThatThrownBy(() -> NumberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}