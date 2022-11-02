package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberValidatorTest {

    @Test
    void 숫자가_아닌_문자_입력_예외() {
        String test = "bellCold";
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.validate(test));
    }
}