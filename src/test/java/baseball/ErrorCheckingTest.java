package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCheckingTest {

    @Test
    void errorChecking() {
        boolean answer = ErrorChecking.errorChecking("123");
        assertTrue(answer);
        boolean answerX = ErrorChecking.errorChecking("false");
        boolean answerY = ErrorChecking.errorChecking("12");
        boolean answerZ = ErrorChecking.errorChecking("103");
        assertFalse(answerX);
        assertFalse(answerY);
        assertFalse(answerZ);
    }

    @Test
    void checkingInputNum() {
        boolean answer  = ErrorChecking.checkingInputNum("123");
        assertTrue(answer);
        boolean answerX = ErrorChecking.checkingInputNum("false");
        assertFalse(answerX);
    }

    @Test
    void checkingDigit() {
        boolean answer = ErrorChecking.checkingDigit("123");
        assertTrue(answer);
        boolean answerX = ErrorChecking.checkingDigit("12");
        assertFalse(answerX);
    }

    @Test
    void checkingContainingZero() {
        boolean answer = ErrorChecking.checkingContainingZero("123");
        assertTrue(answer);
        boolean answerX = ErrorChecking.checkingContainingZero("103");
        assertFalse(answerX);
    }
}