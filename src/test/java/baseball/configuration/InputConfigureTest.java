package baseball.configuration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputConfigureTest {

    @Test
    @DisplayName("정상적인 입력 시")
    void exception_assertion_test_success() {
        assertThatCode(() -> InputConfigure.verifyInput("194"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("비정상적 입력 시 (길이초과)")
    void exception_assertion_test_length_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputConfigure.verifyInput("1234567"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상적 입력 시 (잘못된 단어)")
    void exception_assertion_test_word_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputConfigure.verifyInput("w35"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상적 입력 시 (중복된 단어)")
    void exception_assertion_test_overlap_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputConfigure.verifyInput("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}