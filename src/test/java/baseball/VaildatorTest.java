package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.tools.Validator;

public class VaildatorTest {
    Validator validator;

    @Test
    void Vaildator_정답_올바른3자리숫자() {
        validator = new Validator("123");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isTrue();
    }

    @Test
    void Vaildator_오답_0을포함한숫자() {
        validator = new Validator("023");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isFalse();
    }

    @Test
    void Vaildator_오답_문자와숫자의혼합() {
        validator = new Validator("A23");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isFalse();
    }

    @Test
    void Vaildator_오답_4자리입력() {
        validator = new Validator("1234");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isFalse();
    }

    @Test
    void Vaildator_오답_2자리입력() {
        validator = new Validator("34");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isFalse();
    }

    @Test
    void Vaildator_오답_2자리문자입력() {
        validator = new Validator("ㅁㅁ");
        boolean result = validator.checkBaseballNumber();
        assertThat(result).isFalse();
    }
}
