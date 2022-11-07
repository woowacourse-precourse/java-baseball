package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputValidateTest {
    @Test
    void isValidInput() {

        int EXAMPLE_INVALID_NUMBER_1 = 12345;
        int EXAMPLE_INVALID_NUMBER_2 = 333;
        int EXAMPLE_VALID_NUMBER_1 = 357;
        int EXAMPLE_VALID_NUMBER_2 = 123;

        assertThat(InputValidator.isValidNumbers(EXAMPLE_INVALID_NUMBER_1) && InputValidator.hasDuplicatedNumber(EXAMPLE_INVALID_NUMBER_1)).isFalse();
        assertThat(InputValidator.isValidNumbers(EXAMPLE_INVALID_NUMBER_2) && InputValidator.hasDuplicatedNumber(EXAMPLE_INVALID_NUMBER_2)).isFalse();
        assertThat(InputValidator.isValidNumbers(EXAMPLE_VALID_NUMBER_1) && InputValidator.hasDuplicatedNumber(EXAMPLE_VALID_NUMBER_1)).isTrue();
        assertThat(InputValidator.isValidNumbers(EXAMPLE_VALID_NUMBER_2) && InputValidator.hasDuplicatedNumber(EXAMPLE_VALID_NUMBER_2)).isTrue();
    }
}
