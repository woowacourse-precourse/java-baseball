package study;

import baseball.MakeRandomString;
import baseball.PlayGame;
import org.junit.jupiter.api.*;

import java.io.*;
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

    @Test
    void printResultTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        PlayGame.printResult(Arrays.asList(0, 3));
        PlayGame.printResult(Arrays.asList(2, 1));
        PlayGame.printResult(Arrays.asList(3, 0));
        PlayGame.printResult(Arrays.asList(0, 0));

        assertThat(out.toString()).isEqualTo(
                "3스트라이크\n" +
                        "2볼 1스트라이크\n" +
                        "3볼\n" +
                        "낫싱\n");
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


    @Test
    void resumeGame() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);
        assertThat(PlayGame.isStop()).isEqualTo(false);
    }

    @Test
    void stopGame() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);
        assertThat(PlayGame.isStop()).isEqualTo(true);
    }

    @Test
    void wrongStopInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3".getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> PlayGame.isStop())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
