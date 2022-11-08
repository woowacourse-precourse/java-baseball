package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateTest {
    @Test
    public void inputExceptionTest1() {
        assertThatThrownBy(() -> Application.validateEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void inputExceptionTest2() {
        assertThatThrownBy(() -> Application.validateSize("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void inputExceptionTest3() {
        assertThatThrownBy(() -> Application.validateOverlap("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "023", "ㄱ"})
    public void inputExceptionTest4(String item) {
        assertThatThrownBy(() -> Application.validateNumber(item))
                .isInstanceOf(IllegalArgumentException.class);
    }
}