package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsIntWithNonzeroDigitsMethodTest {
    @Test
    void isIntWithNonzeroDigits_반환값_테스트1() {
        String consoleInput = "123";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isIntWithNonzeroDigits_반환값_테스트2() {
        String consoleInput = "456";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isIntWithNonzeroDigits_반환값_테스트3() {
        String consoleInput = "789";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isIntWithNonzeroDigits_반환값_테스트4() {
        String consoleInput = "102";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isIntWithNonzeroDigits_반환값_테스트5() {
        String consoleInput = "35#";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isIntWithNonzeroDigits_반환값_테스트6() {
        String consoleInput = "!@#";
        Boolean result = Application.isIntWithNonzeroDigits(consoleInput);
        assertThat(result).isEqualTo(false);
    }
}