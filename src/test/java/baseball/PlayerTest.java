package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void isDigitTest() {
        Player player = new Player();
        boolean result = true;
        char digit = '3';
        assertThat(player.isDigit(digit)).isEqualTo(result);
        digit = '8';
        assertThat(player.isDigit(digit)).isEqualTo(result);
        result = false;
        digit = 'd';
        assertThat(player.isDigit(digit)).isEqualTo(result);
        digit = '0';
        assertThat(player.isDigit(digit)).isEqualTo(result);
    }
}
