package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("같은 숫자가 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"111", "999", "122", "991", "121"})
    void validateSameNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}