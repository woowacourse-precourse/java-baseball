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
        InputNumberExceptionChecker inputNumberExceptionChecker;
        inputNumberExceptionChecker = new InputNumberExceptionChecker();
        assertThat(inputNumberExceptionChecker.hasZero("789"))
                .isEqualTo(true);
        assertThat(inputNumberExceptionChecker.hasZero("101"))
                .isEqualTo(false);

    }

    @Test
    void isValidRestartNumber() {
        InputNumberExceptionChecker inputNumberExceptionChecker;
        inputNumberExceptionChecker = new InputNumberExceptionChecker();
        assertThat(inputNumberExceptionChecker.isValidRestartNumber(1))
                .isEqualTo(true);
        assertThat(inputNumberExceptionChecker.isValidRestartNumber(2))
                .isEqualTo(true);
        assertThat(inputNumberExceptionChecker.isValidRestartNumber(3))
                .isEqualTo(false);
    }

    @Test
    void hasExceptionStringParameter() {
    }

    @Test
    void hasExceptionIntParameter() {
    }
}