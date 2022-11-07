package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsDigitDuplicatedMethodTest {
    @Test
    void isDigitDuplicated_반환값_테스트1() {
        String consoleInput = "777";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isDigitDuplicated_반환값_테스트2() {
        String consoleInput = "123";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isDigitDuplicated_반환값_테스트3() {
        String consoleInput = "119";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isDigitDuplicated_반환값_테스트4() {
        String consoleInput = "789";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isDigitDuplicated_반환값_테스트5() {
        String consoleInput = "191";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isDigitDuplicated_반환값_테스트6() {
        String consoleInput = "233";
        Boolean result = Application.isDigitDuplicated(consoleInput);
        assertThat(result).isEqualTo(true);
    }
}