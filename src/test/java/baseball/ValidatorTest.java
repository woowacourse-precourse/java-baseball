package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 길이가_3_이상일_때_예외_발생() {
        String input = "12";
        assertThatThrownBy(() -> Validator.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.LENGTH_EXCEPTION);
    }

    @Test
    void 길이가_3_이하일_때_예외_발생() {
        String input = "1234";
        assertThatThrownBy(() -> Validator.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.LENGTH_EXCEPTION);
    }

    @Test
    void 숫자_1부터_9_이외의_숫자가_포함됐을_때_예외_발생() {
        String input = "012";
        assertThatThrownBy(() -> Validator.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.DIGIT_EXCEPTION);
    }

    @Test
    void 문자가_포함됐을_때_예외_발생() {
        String input = "abc";
        assertThatThrownBy(() -> Validator.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.DIGIT_EXCEPTION);
    }

    @Test
    void 중복_숫자가_포함됐을_때_예외_발생() {
        String input = "112";
        assertThatThrownBy(() -> Validator.validateNoDuplication(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.DUPLICATION_EXCEPTION);
    }

    @Test
    void 숫자_1_또는_2_이외의_숫자가_입력됐을_때_예외_발생() {
        String input = "3";
        assertThatThrownBy(() -> Validator.validateResponse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.RESPONSE_EXCEPTION);
    }
}