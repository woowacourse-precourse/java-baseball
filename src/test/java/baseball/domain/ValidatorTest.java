package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setValidator() {
        validator = new Validator();
    }

    @Test
    void 유효하지_않은_숫자_검증() {
        String num1 = "   122   ";
        assertThatThrownBy(() -> validator.isValidate(num1)).isInstanceOf(IllegalArgumentException.class);

        String num2 = "   1234   ";
        assertThatThrownBy(() -> validator.isValidate(num2)).isInstanceOf(IllegalArgumentException.class);

        String num4 = "210";
        assertThatThrownBy(() -> validator.isValidate(num4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_숫자_검증() {
        String num3 = "   123   ";
        validator.isValidate(num3);
        assertThatNoException();
    }

    @Test
    void 숫자_검증() {
        String num = "aa";
        assertThat(validator.isNumeric(num)).isFalse();
    }
}
