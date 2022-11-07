package baseball;

import constant.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validator.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void 시작_끝_입력값_예외_테스트() {
        String input = "3";

        assertThatThrownBy(() -> Validator.checkStartOrEndInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_START_OR_END);
    }

    @Test
    void 숫자_입력값_형식_예외_테스트() {
        String input = "abc";

        assertThatThrownBy(() -> Validator.checkInputNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INCORRECT_NUMBER);
    }

    @Test
    void 숫자_입력값_길이_에외_테스트() {
        String input = "5321";

        assertThatThrownBy(() -> Validator.checkInputNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NUMBER_LENGTH);
    }

    @Test
    void 숫자_입력값_중복_예외_테스트() {
        String input = "151";

        assertThatThrownBy(() -> Validator.checkInputNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER);
    }
}
