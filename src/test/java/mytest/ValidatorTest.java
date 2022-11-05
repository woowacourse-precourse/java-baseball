package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.settings.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("입력값이 1과 9 사이의 서로 다른 세 자리 수가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void case1() {
        assertThatThrownBy(() -> Validator.check("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case2() {
        assertThatThrownBy(() -> Validator.check("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case3() {
        assertThatThrownBy(() -> Validator.check("803"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case4() {
        assertThatThrownBy(() -> Validator.check("6a4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case5() {
        assertThatThrownBy(() -> Validator.check("**2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
