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

    @ParameterizedTest
    @CsvSource(value = {"a, true", "abc, true", "1, false", "123, false"})
    void isNot1To9(String input, boolean expected) {
        boolean actual = inputValidation.isNot1To9(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"11, true", "aa, true", "121, true", "aba, true", "123, false", "abc, false"})
    void hasDuplicatedValues(String input, boolean expected) {
        boolean actual = inputValidation.hasDuplicatedValues(input);
        assertThat(actual).isEqualTo(expected);
    }
}