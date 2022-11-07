package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartNumberValidatorTest {

    @DisplayName("1이나 2가 아니면 IllegalArgumentException")
    @Test
    void checkValidationRestartNumber_예외() {
        String restartNumber = "3";
        Assertions.assertThrows(RuntimeException.class, () -> {
            RestartNumberValidator.checkValidationRestartNumber(restartNumber);
        });
    }

}