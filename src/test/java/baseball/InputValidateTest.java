package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputValidateTest {
    @Test
    void isValidInput() {


        String INVALID_NUMBER_1 = "12345";
        String INVALID_NUMBER_2 = "333";
        String VALID_NUMBER_1 = "357";
        String VALID_NUMBER_2 = "123";

        assertThat(InputValidator.isValidNumbers(INVALID_NUMBER_1) && InputValidator.hasDuplicatedNumber(INVALID_NUMBER_1)).isFalse();
        assertThat(InputValidator.isValidNumbers(INVALID_NUMBER_2) && InputValidator.hasDuplicatedNumber(INVALID_NUMBER_2)).isFalse();
        assertThat(InputValidator.isValidNumbers(VALID_NUMBER_1) && InputValidator.hasDuplicatedNumber(VALID_NUMBER_1)).isTrue();
        assertThat(InputValidator.isValidNumbers(VALID_NUMBER_2) && InputValidator.hasDuplicatedNumber(VALID_NUMBER_2)).isTrue();
    }
}
