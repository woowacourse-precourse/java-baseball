package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationMethodsTest {

    @Test
    void generateRandomNumberTest() {
        String randomNumber = Application.generateRandomNumber();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < randomNumber.length(); i++) {
            hashSet.add(randomNumber.charAt(i));
        }
        assertThat(randomNumber.length()).isEqualTo(3);
        assertThat(randomNumber.length()).isEqualTo(hashSet.size());
    }

    @Test
    void validateInputNumberTest() {
        try {
            String testNumber = "1789";
            Application.validateInputNumber(testNumber);
            fail();
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    @Test
    void isAllInRangeTest() {
        String testNumber1 = "123";
        String testNumber2 = "012";

        boolean result1 = Application.isAllInRange(testNumber1);
        boolean result2 = Application.isAllInRange(testNumber2);


        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void isAllUniqueTest() {
        String testNumber1 = "123";
        String testNumber2 = "114";

        boolean result1 = Application.isAllUnique(testNumber1);
        boolean result2 = Application.isAllUnique(testNumber2);

        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void checkStrikeTest() {
        String randomNumber = "957";
        String inputNumber = "937";

        int strikeCount = Application.checkStrike(randomNumber, inputNumber);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void checkBallTest() {
        String randomNumber = "123";
        String inputNumber = "351";

        int strikeCount = Application.checkBall(randomNumber, inputNumber);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void printResult() {
        int ballCount = 1;
        int strikeCount = 1;

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Application.printResult(ballCount, strikeCount);
        String result = outputStreamCaptor.toString().trim();

        assertEquals(result, "1볼 1스트라이크");
        System.setOut(System.out);
    }

    @Test
    void playGame() {
        String randomNumber = "915";
        String input = "123\n" + "918\n" + "951\n" + "248\n" + "915";

        OutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Application.playGame(randomNumber);
        String result = outputStreamCaptor.toString().trim();

        Assertions.assertThat(result).contains("1볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "낫싱");
    }
}
