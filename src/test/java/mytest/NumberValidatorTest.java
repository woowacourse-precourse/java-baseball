package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    @DisplayName("입력값이 1과 9 사이의 서로 다른 세 자리 수가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void case1() {
        assertThatThrownBy(() -> NumberValidator.check("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case2() {
        assertThatThrownBy(() -> NumberValidator.check("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case3() {
        assertThatThrownBy(() -> NumberValidator.check("803"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case4() {
        assertThatThrownBy(() -> NumberValidator.check("6a4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case5() {
        assertThatThrownBy(() -> NumberValidator.check("**2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
