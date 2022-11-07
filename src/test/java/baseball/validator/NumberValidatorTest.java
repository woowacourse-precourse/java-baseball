package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberValidatorTest {

    @Test
    void 숫자가_아닌_문자_입력_예외() {
        assertThatThrownBy(() -> NumberValidator.validateUserAnswer("bellCold"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자_입력시_예외() {
        assertThatThrownBy(() -> NumberValidator.validateUserAnswer("772"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리가_아닌_숫자_입력시_예외() {
        assertThatThrownBy(() -> NumberValidator.validateUserAnswer("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_입력시_에러_메시지() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> NumberValidator.validateUserAnswer("bellCold")
        );
        assertEquals("Only numbers can be entered.", exception.getMessage());
    }

    @Test
    void 중복된_숫자_입력_에러_메시지() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> NumberValidator.validateUserAnswer("112")
        );
        assertEquals("Duplicate numbers cannot be entered.", exception.getMessage());
    }

    @Test
    void 세자리수가_아닌_숫자_입력_에러_메시지() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> NumberValidator.validateUserAnswer("12")
        );
        assertEquals("It's not a three-digit number.", exception.getMessage());
    }

    @Test
    void 재시작_종료_숫자_테스트() {
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validateUserAnswer("3"));
    }
}