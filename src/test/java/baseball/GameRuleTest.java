package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRuleTest {

    @Test
    void compareStringTest() {
        assertThat(PlayGame.compareString("123", "123")).isEqualTo(Arrays.asList(0, 3));
        assertThat(PlayGame.compareString("123", "321")).isEqualTo(Arrays.asList(2, 1));
        assertThat(PlayGame.compareString("123", "312")).isEqualTo(Arrays.asList(3, 0));
        assertThat(PlayGame.compareString("123", "456")).isEqualTo(Arrays.asList(0, 0));
    }

    @Nested
    class printResultTest {

        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void clear() {
            outputStreamCaptor.reset();
        }

        @Test
        void onlyStrike() {
            PlayGame.printResult(Arrays.asList(0, 3));
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
        }

        @Test
        void onlyBall() {
            PlayGame.printResult(Arrays.asList(3, 0));
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3볼");
        }

        @Test
        void strikeAndBall() {
            PlayGame.printResult(Arrays.asList(2, 1));
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void nothing() {
            PlayGame.printResult(Arrays.asList(0, 0));
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
        }
    }

    @Nested
    class checkInputStringTest {
        @Test
        void checkInputLength() {
            assertThat(PlayGame.checkInputLength("1")).isEqualTo(true);
            assertThat(PlayGame.checkInputLength("123")).isEqualTo(false);
            assertThat(PlayGame.checkInputLength("1234")).isEqualTo(true);
        }

        @Test
        void checkInputRepetition() {
            assertThat(PlayGame.checkInputRepetition("123")).isEqualTo(false);
            assertThat(PlayGame.checkInputRepetition("111")).isEqualTo(true);
        }

        @Test
        void checkInputInteger() {
            assertThat(PlayGame.checkInputInteger("123")).isEqualTo(false);
            assertThat(PlayGame.checkInputInteger("abc")).isEqualTo(true);
        }
    }
}
