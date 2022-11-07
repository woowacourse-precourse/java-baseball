package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateCodeMethodTest {
    @Test
    void 게임_후_입력_예외_테스트1() {
        String executionCode = "3";
        assertThatThrownBy(() -> Application.validateCode(executionCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }

    @Test
    void 게임_후_입력_예외_테스트2() {
        String executionCode = "neppiness";
        assertThatThrownBy(() -> Application.validateCode(executionCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }

    @Test
    void 게임_후_입력_예외_테스트3() {
        String executionCode = "0";
        assertThatThrownBy(() -> Application.validateCode(executionCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }
}