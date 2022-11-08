package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class InputNumberExceptionCheckerTest {

    @Test
    void isValidLength() {
        InputNumberExceptionChecker inputNumberExceptionChecker;
        inputNumberExceptionChecker = new InputNumberExceptionChecker();
        assertThat(inputNumberExceptionChecker.isValidLength("123"))
                .isEqualTo(true);
        assertThat(inputNumberExceptionChecker.isValidLength("1234"))
                .isEqualTo(false);
    }

    @Test
    void hasDifferentNumberElement() {
        InputNumberExceptionChecker inputNumberExceptionChecker;
        inputNumberExceptionChecker = new InputNumberExceptionChecker();
        assertThat(inputNumberExceptionChecker.hasDifferentNumberElement("456"))
                .isEqualTo(true);
        assertThat(inputNumberExceptionChecker.hasDifferentNumberElement("111"))
                .isEqualTo(false);

    }

    @Test
    void hasZero() {
    }

    @Test
    void isValidRestartNumber() {
    }

    @Test
    void hasException() {
    }

    @Test
    void testHasException() {
    }
}