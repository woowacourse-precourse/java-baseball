package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.utils.Validator;

public class ValidatorTest {
    Validator validator;

    @Test
    void 정답_올바른3자리숫자() {
        validator = new Validator();
        boolean result = validator.isValidString("123");
        assertThat(result).isTrue();
    }

    @Test
    void 오답_0을포함한숫자() {
        validator = new Validator();
        boolean result = validator.isValidString("023");
        assertThat(result).isFalse();
    }

    @Test
    void 오답_중복을포함한숫자() {
        validator = new Validator();
        boolean result = validator.isValidString("112");
        assertThat(result).isFalse();
    }

    @Test
    void 오답_네글자숫자() {
        validator = new Validator();
        boolean result = validator.isValidString("1234");
        assertThat(result).isFalse();
    }

    @Test
    void 오답_2자리숫자() {
        validator = new Validator();
        boolean result = validator.isValidString("12");
        assertThat(result).isFalse();
    }

    @Test
    void 오답_문자포함입력() {
        validator = new Validator();
        boolean result = validator.isValidString("a21");
        assertThat(result).isFalse();
    }
}
