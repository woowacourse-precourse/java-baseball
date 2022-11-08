package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCheckingTest {

    @Test
    void errorChecking() {
    }

    @Test
    void checkingInputNum() {
    }

    @Test
    void checkingDigit() {
        boolean answer = ErrorChecking.checkingDigit("123");
        assertTrue(answer);
        boolean answerX = ErrorChecking.checkingDigit("12");
        assertFalse(answerX);
    }

    @Test
    void checkingContaingZero() {
    }
}