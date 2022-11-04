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

    @Test
    void 게임_재진행여부_올바른값() {
        String input = "1";
        InputValidator.checkProgressInput(input);

        input = "2";
        InputValidator.checkProgressInput(input);
    }

    @Test
    void 게임_재진행여부_잘못된값() {
        String input1 = "3";
        assertThatThrownBy(() -> InputValidator.checkProgressInput(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "t";
        assertThatThrownBy(() -> InputValidator.checkProgressInput(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "12";
        assertThatThrownBy(() -> InputValidator.checkProgressInput(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
