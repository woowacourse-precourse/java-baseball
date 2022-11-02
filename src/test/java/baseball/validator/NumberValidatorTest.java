package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberValidatorTest {

    @Test
    void 숫자가_아닌_문자_입력_예외() {
        String userNumber = "bellCold";
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validate(userNumber));
    }

    @Test
    void 중복된_숫자_입력시_예외() {
        String userNumber = "777";
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validate(userNumber));
    }
}