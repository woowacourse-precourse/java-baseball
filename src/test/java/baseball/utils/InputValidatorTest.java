package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 게임_입력값_올바른값() {
        InputValidator.checkBaseballInput("321");

        InputValidator.checkBaseballInput("154");

        InputValidator.checkBaseballInput("926");
    }

    @Test
    void 게임_입력값_잘못된값() {
        assertThatThrownBy(() -> InputValidator.checkBaseballInput("3test"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput("tes"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput("#$@"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput("333"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput("226"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkBaseballInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재진행여부_올바른값() {
        InputValidator.checkProgressInput("1");

        InputValidator.checkProgressInput("2");
    }

    @Test
    void 게임_재진행여부_잘못된값() {
        assertThatThrownBy(() -> InputValidator.checkProgressInput("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkProgressInput("t"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkProgressInput("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkProgressInput(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidator.checkProgressInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
