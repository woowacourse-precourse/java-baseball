package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateMethodTest {
    @Test
    void 게임_후_입력_예외_테스트1() {
        Application.ExecutionCode executionCode = new Application.ExecutionCode();
        executionCode.code = "3";
        assertThatThrownBy(() -> executionCode.validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }

    @Test
    void 게임_후_입력_예외_테스트2() {
        Application.ExecutionCode executionCode = new Application.ExecutionCode();
        executionCode.code = "neppiness";
        assertThatThrownBy(() -> executionCode.validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }

    @Test
    void 게임_후_입력_예외_테스트3() {
        Application.ExecutionCode executionCode = new Application.ExecutionCode();
        executionCode.code = "0";
        assertThatThrownBy(() -> executionCode.validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Execution code must be 1 or 2");
    }
}