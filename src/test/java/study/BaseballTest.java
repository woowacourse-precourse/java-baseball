package study;

import baseball.MakeRandomString;
import baseball.PlayGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

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

    @Test
    void compareStringTest() {
        assertThat(PlayGame.compareString("123", "123")).isEqualTo(Arrays.asList(0, 3));
        assertThat(PlayGame.compareString("123", "321")).isEqualTo(Arrays.asList(2, 1));
        assertThat(PlayGame.compareString("123", "312")).isEqualTo(Arrays.asList(3, 0));
        assertThat(PlayGame.compareString("123", "456")).isEqualTo(Arrays.asList(0, 0));
    }
}
