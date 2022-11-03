package baseball.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidationTest {

    InputValidation validation = new InputValidation();

    @Test
    void validateNumber() {
        assertThrows(IllegalArgumentException.class, () -> validation.validateNumber("abc"));
        assertThrows(IllegalArgumentException.class, () -> validation.validateNumber("1234"));
        assertThrows(IllegalArgumentException.class, () -> validation.validateNumber("012"));
    }
}