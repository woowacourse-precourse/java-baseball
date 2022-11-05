package baseball.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validator validator = new Validator();

    @Test
    void 입력_유효성_검사_숫자가_아닌_경우() {
        String input = "a75";
        Assertions.assertThatThrownBy(()->
                validator.validateInputNumbers(input))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_유효성_검사_범위를_벗어난_경우() {
        String input = "010";
        Assertions.assertThatThrownBy(()->
                validator.validateInputNumbers(input))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_유효성_검사_길이가_3이_아닌_경우() {
        String input = "46678";
        Assertions.assertThatThrownBy(()->
                validator.validateInputNumbers(input)).
                        isInstanceOf(IllegalArgumentException.class);
    }
}