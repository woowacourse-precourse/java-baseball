package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {

    @Test
    void occur_올바르지_않는_입력_길이() {
        String input = "1234";

        assertThatThrownBy(() -> InputException.occur(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void occur_문자_입력() {
        String input = "abc";

        assertThatThrownBy(() -> InputException.occur(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void occur_0을_포함하는_입력() {
        String input = "920";

        assertThatThrownBy(() -> InputException.occur(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void occur_중복을_포함하는_입력() {
        String input = "889";

        assertThatThrownBy(() -> InputException.occur(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void occur_올바른_숫자_입력() {
        String input = "123";

        assertThat(InputException.occur(input)).isEqualTo(false);
    }
}
