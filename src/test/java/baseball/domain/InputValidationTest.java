package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.validation.InputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidationTest {
    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "12, true", "123, false", "1234, true", "12345, true"})
    void isNotThreeLetters(String input, boolean expected) {
        boolean actual = inputValidation.isNotThreeLetters(input);
        assertThat(actual).isEqualTo(expected);
    }
}