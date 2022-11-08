package baseball.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {

    @Test
    void isValidUserNumber() {
        boolean result = true;

        GameNumber gameNumber = new GameNumber();

        assertThat(gameNumber.isValidUserNumber("123")).isEqualTo(result);
    }

    @Test
    void generateRandomNumber() {
        boolean result = true;

        GameNumber randomNumber = new GameNumber();

        for (int loop = 0; loop < 100; loop++) {
            randomNumber.generateRandomNumber();

            assertThat(GameNumber.isValidUserNumber(randomNumber.getGameNumber())).isEqualTo(result);
        }

    }

    @Test
    void getGameNumber() {
        String result = "123";

        GameNumber gameNumber = new GameNumber("123");

        assertThat(gameNumber.getGameNumber()).isEqualTo(result);
    }
}