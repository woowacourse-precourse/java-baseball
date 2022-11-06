package baseball.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameNumberTest {

    @Test
    void getNumber() {
        String result = "123";
        GameNumber gameNumber = new GameNumber("123");
        assertThat(gameNumber.getNumber()).isEqualTo(result);
    }

    @Test
    void isValidateNumber() {
        boolean result = true;
        String number = "123";
        assertThat(number).isEqualTo(result);
    }

    @Test
    void generate() {
        GameNumber randomNumber = new GameNumber();
        boolean result = true;

        for (int loop = 0; loop < 100; loop++){
            randomNumber.generate();
            assertThat(GameNumber.isValidateNumber(randomNumber.getNumber())).isEqualTo(result);
        }
    }
}