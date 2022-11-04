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

    @Test
    void isThreeLetterTest() {
        Player player = new Player();
        boolean result = true;
        String number = "omg";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
        number = "007";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
        number = "178";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
        result = false;
        number = "12";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
        number = "2345";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
        number = "";
        assertThat(player.isThreeLetter(number)).isEqualTo(result);
    }

    @Test
    void isAllDifferentTest() {
        Player player = new Player();
        boolean result = true;
        String number = "abc";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
        number = "8n3";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
        number = "827";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
        result = false;
        number = "0o0";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
        number = "100";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
        number = "tnt";
        assertThat(player.isAllDifferent(number)).isEqualTo(result);
    }
}
