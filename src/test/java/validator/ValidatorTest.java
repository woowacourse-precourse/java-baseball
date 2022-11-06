package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private static final String LENGTH_VALIDATION_FAILED = "입력한 숫자의 길이가 3이 아닙니다.";

    @Test
    @DisplayName("입력한 수의 길이가 3임을 정확히 검증하는 가?")
    void validate_length_test() {
        int unitSize = 3;
        String input1 = "123";
        String input2 = "1234";
        String input3 = "12";

        assertThat(Validator.validateLength(input1, unitSize)).isTrue();
        assertThatThrownBy(() -> Validator.validateLength(input2, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateLength(input3, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
    }
}
