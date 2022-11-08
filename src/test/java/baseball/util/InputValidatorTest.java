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

    @DisplayName("숫자에 0이 포함되어 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"120", "102", "034"})
    void validateZero(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 3자리가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "9876", "98", "12345"})
    void validateLength(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 이외의 문자를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a34", "1a2", "98i", "ㅣ98", "4ㅜ5", "67;", "9+8"})
    void validateNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}