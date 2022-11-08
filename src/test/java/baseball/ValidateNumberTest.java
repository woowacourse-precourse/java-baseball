package baseball;

import baseball.utils.InputValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateNumberTest {

    InputValidation validation = new InputValidation();
    @Test
    void validateNumber() {
        assertThrows(IllegalArgumentException.class, () -> validation.validationNumber("few"));
        assertThrows(IllegalArgumentException.class, () -> validation.validationNumber("45586"));
        assertThrows(IllegalArgumentException.class, () -> validation.validationNumber("012"));
    }

}
