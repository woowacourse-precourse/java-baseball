package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsCorrectLengthMethodTest {
    @Test
    void isCorrectLength_반환값_테스트1() {
        String consoleInput = "3";
        Boolean result = Application.isCorrectLength(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isCorrectLength_반환값_테스트2() {
        String consoleInput = "1234";
        Boolean result = Application.isCorrectLength(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isCorrectLength_반환값_테스트3() {
        String consoleInput = "-123**";
        Boolean result = Application.isCorrectLength(consoleInput);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isCorrectLength_반환값_테스트4() {
        String consoleInput = "#!*";
        Boolean result = Application.isCorrectLength(consoleInput);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isCorrectLength_반환값_테스트5() {
        String consoleInput = "123";
        Boolean result = Application.isCorrectLength(consoleInput);
        assertThat(result).isEqualTo(true);
    }
}