package baseball.validation;

import org.junit.jupiter.api.Test;

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

}