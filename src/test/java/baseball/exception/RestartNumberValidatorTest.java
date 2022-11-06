package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestartNumberValidatorTest {

    @Test
    void checkValidationRestartNumber_예외() {
        String restartNumber = "3";
        Assertions.assertThrows(RuntimeException.class, () -> {
            RestartNumberValidator.checkValidationRestartNumber(restartNumber);
        });
    }

}