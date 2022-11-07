package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UnitTest {

    @Test
    void randomNumberLengthTest() {
        String randomNumber = Application.getRandomNumber();
        Assertions.assertThat(randomNumber).hasSize(3);
    }

    @Test
    void randomNumberRangeTest() {
        Integer randomNumber = Integer.parseInt(Application.getRandomNumber());
        Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(123).isLessThanOrEqualTo(987);
    }

    @Test
    void randomNumberDuplicateTest() {
        String randomNumber = Application.getRandomNumber();
        String[] number = randomNumber.split("");
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                Assertions.assertThat(number[i]).isNotEqualTo(number[j]);
            }
        }
    }

    @Test
    void userInputTest() {
        InputStream inputStream = System.in;

        ByteArrayInputStream input1 = new ByteArrayInputStream("1234".getBytes());
        System.setIn(input1);
        Assertions.assertThatThrownBy(() -> {
            Application.getUserInputNumber();
        }).isInstanceOf(IllegalArgumentException.class);

        ByteArrayInputStream input2 = new ByteArrayInputStream("-321".getBytes());
        System.setIn(input2);
        Assertions.assertThatThrownBy(() -> {
            Application.getUserInputNumber();
        }).isInstanceOf(IllegalArgumentException.class);

        ByteArrayInputStream input3 = new ByteArrayInputStream("474".getBytes());
        System.setIn(input3);
        Assertions.assertThatThrownBy(() -> {
            Application.getUserInputNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void strikeCountTest() {
        String randomNumber = "364";
        String userInput = "346";
        Integer strikeCount = Application.getStrikeCount(userInput, randomNumber);
        Assertions.assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void ballCountTest() {
        String randomNumber = "653";
        String userInput = "536";
        Integer ballCount = Application.getBallCount(userInput, randomNumber);
        Assertions.assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void isThreeStrikeTest() {
        Integer strikeCount = 3;
        Assertions.assertThat(Application.isThreeStrike(strikeCount)).isTrue();

        strikeCount = 2;
        Assertions.assertThat(Application.isThreeStrike(strikeCount)).isFalse();
    }
}
