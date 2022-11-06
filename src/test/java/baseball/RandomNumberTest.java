package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    static String randomNumber = "";

    @BeforeAll
    static void makeRandomNumber() {
        randomNumber = MakeRandomString.run();
    }

    @Test
    void randomNumberLength() {
        assertThat(randomNumber.length()).isEqualTo(3);
    }

    @Test
    void randomNumberRepetition() {
        char randomNumberFirst = randomNumber.charAt(0);
        char randomNumberSecond = randomNumber.charAt(1);
        char randomNumberThird = randomNumber.charAt(2);

        assertThat(randomNumberFirst).isNotEqualTo(randomNumberSecond);
        assertThat(randomNumberFirst).isNotEqualTo(randomNumberThird);
        assertThat(randomNumberSecond).isNotEqualTo(randomNumberThird);
    }
}
