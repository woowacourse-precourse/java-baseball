package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 정수형이_아니면_예외를_던지는지_테스트() {
        char character = 'a';
        assertThatThrownBy(() -> Validator.validateInteger(character))
                .isInstanceOf(IllegalArgumentException.class);

    }
}