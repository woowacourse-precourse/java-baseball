package study;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.CheckException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @Test
    void check_입력값_길이_예외처리_검증() {
        String input_true = "123";
        String input_false = "1234";
        assertThat(CheckException.checkNumberLength(input_true)).isEqualTo(true);
        assertThat(CheckException.checkNumberLength(input_false)).isEqualTo(false);
    }

    @Test
    void check_입력값_숫자_예외검증() {
        String input_true = "123";
        String input_false = "asdf";
        assertThat(CheckException.checkNumeric(input_true)).isEqualTo(true);
        assertThat(CheckException.checkNumeric(input_false)).isEqualTo(false);
    }

}
