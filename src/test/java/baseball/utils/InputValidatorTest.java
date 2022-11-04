package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 게임_입력값_올바른값() {
        String input = "321";
        InputValidator.checkBaseballInput(input);

        input = "154";
        InputValidator.checkBaseballInput(input);

        input = "926";
        InputValidator.checkBaseballInput(input);
    }

    @Test
    void 게임_입력값_잘못된값() {
        String input1 = "3test";
        assertThatThrownBy(() -> InputValidator.checkBaseballInput(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "tes";
        assertThatThrownBy(() -> InputValidator.checkBaseballInput(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "#$@";
        assertThatThrownBy(() -> InputValidator.checkBaseballInput(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}