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

    @Test
    void isNumberTest() {
        Player player = new Player();
        boolean result = true;
        String number = "317";
        assertThat(player.isNumber(number)).isEqualTo(result);
        number = "222";
        assertThat(player.isNumber(number)).isEqualTo(result);
        result = false;
        number = "703";
        assertThat(player.isNumber(number)).isEqualTo(result);
        number = "d32";
        assertThat(player.isNumber(number)).isEqualTo(result);
    }
}
