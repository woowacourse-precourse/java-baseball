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
        assertThatThrownBy(() -> inputValidation.validatePlayerNumbersInput(input))
                .hasMessage("3자리 수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("1부터 9까지 수가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"abc", "가나다", "a1b", "12가", "102", "1 2"})
    void validateNumberRange(String input) {
        assertThatThrownBy(() -> inputValidation.validatePlayerNumbersInput(input))
                .hasMessage("1부터 9까지의 수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복이 있을 경우 예외 발생 확인")
    @CsvSource(value = {"112", "121", "333"})
    void validateDuplication(String input) {
        assertThatThrownBy(() -> inputValidation.validatePlayerNumbersInput(input))
                .hasMessage("각 자리의 수가 서로 달라야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("1 또는 2가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"0", "3", "4", "a"})
    void validateChoice(String input) {
        assertThatThrownBy(() -> inputValidation.validateRestartInput(input))
                .hasMessage("1 또는 2를 입력해야 합니다.");
    }
}