package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateInputMethodTest {
    @Test
    void 게임_중_입력_예외_테스트1() {
        String consoleInput = "3";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트2() {
        String consoleInput = "neppiness";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트3() {
        String consoleInput = "1235";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트4() {
        String consoleInput = "102";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트5() {
        String consoleInput = "064";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트6() {
        String consoleInput = "777";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should consist of non-duplicated digits");
    }

    @Test
    void 게임_중_입력_예외_테스트7() {
        String consoleInput = "313";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should consist of non-duplicated digits");
    }

    @Test
    void 게임_중_입력_예외_테스트8() {
        String consoleInput = "5050";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트9() {
        String consoleInput = "*/a";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트10() {
        String consoleInput = "abc";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }

    @Test
    void 게임_중_입력_예외_테스트11() {
        String consoleInput = "김정현";
        assertThatThrownBy(() -> Application.validateInput(consoleInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be 3-digit integer with non-zero digits");
    }
}