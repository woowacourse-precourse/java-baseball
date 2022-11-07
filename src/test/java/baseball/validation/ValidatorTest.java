package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int COUNT_VALUE = 3;

    @Test
    void validateInputLength() {
        assertThatThrownBy(() -> {Validator.validatePlayerInput("1234");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[IllegalArgumentException]: " + COUNT_VALUE + "자리 자리자연수가 아닙니다.\n");
    }

    @Test
    void validateInputInteger() {
        assertThatThrownBy(() -> {Validator.validatePlayerInput("abc");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[IllegalArgumentException]: 정수가 아닙니다.\n");
    }

    @Test
    void validateInputNumberScope() {
        assertThatThrownBy(() -> {Validator.validatePlayerInput("120");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[IllegalArgumentException]: 각 자릿수가 " + MIN_VALUE + "~" + MAX_VALUE + "사이 숫자가 아닙니다.\n");
    }

    @Test
    void validateInputDuplication() {
        assertThatThrownBy(() -> {Validator.validatePlayerInput("111");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[IllegalArgumentException]: 각 자릿수에 중복이 있습니다.\n");
    }

    @Test
    void validateInputRestartOrEnd() {
        assertThatThrownBy(() -> {Validator.validateInputRestartOrEnd("3");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[IllegalArgumentException]: 새로 시작(1)/종료하(2)중 하나의 수가 아닙니다.\n");
    }

}