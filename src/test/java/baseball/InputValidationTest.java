package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidationTest {
    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @DisplayName("세글자가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"1", "12", "1234", "12345"})
    void validateLength(String input) {
        assertThatThrownBy(() -> inputValidation.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1부터 9까지 수가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"a", "abc", "가나다"})
    void validateNumberRange(String input) {
        assertThatThrownBy(() -> inputValidation.validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("중복이 있을 경우 예외 발생 확인")
    @CsvSource(value = {"11", "aa", "121", "aba"})
    void validateDuplication(String input) {
        assertThatThrownBy(() -> inputValidation.validateDuplication(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1 또는 2가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"0", "3", "4", "a"})
    void validateChoice(String input) {
        assertThatThrownBy(() -> inputValidation.validateChoice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}