package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 입력값이_문자일_때_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNumber("가나다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값을 입력하였습니다.");
    }

    @Test
    void 입력값이_세_자리가_아닌_수일_때_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}