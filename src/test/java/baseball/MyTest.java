package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {

    @Test
    void computerNumberSizeTest() {
        Application.initComputerNumber();

        List<Character> computerNumber = Application.computerNumber;

        Assertions.assertThat(computerNumber).size().isEqualTo(3);
    }

    @Test
    void computerNumberRangeTest() {
        Application.initComputerNumber();

        List<Character> computerNumber = Application.computerNumber;

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(computerNumber.get(i)).isBetween('1', '9');
        }
    }

    @Test
    void checkStrike() {
        Application.computerNumber = List.of('1', '2', '3');

        int strikeCount = Application.checkStrike("456");

        Assertions.assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void checkBall() {
        Application.computerNumber = List.of('1', '2', '3');

        int ballCount = Application.checkBall("312");

        Assertions.assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void checkNothing() {
        Application.computerNumber = List.of('1', '2', '3');

        boolean nothingFlag = Application.checkNothing("456");

        Assertions.assertThat(nothingFlag).isTrue();
    }


    @Test
    void validateUserInputSize() {
        String userInput = "1234";

        try {
            Application.validateUserInputSize(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void validateUserInputForm() {
        String userInput = "ABC";

        try {
            Application.validateUserInputSize(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Test
    void giveHint() {
        Application.computerNumber = List.of('1', '2', '3');
        String userInput_one = "132";
        String userInput_two = "123";
        String userInput_three = "456";
        String userInput_four = "431";

        String hintMessage_one = Application.giveHint(userInput_one);
        String hintMessage_two = Application.giveHint(userInput_two);
        String hintMessage_three = Application.giveHint(userInput_three);
        String hintMessage_four = Application.giveHint(userInput_four);

        Assertions.assertThat(hintMessage_one).isEqualTo("2볼 1스트라이크");
        Assertions.assertThat(hintMessage_two).isEqualTo("3스트라이크");
        Assertions.assertThat(hintMessage_three).isEqualTo("낫싱");
        Assertions.assertThat(hintMessage_four).isEqualTo("2볼 ");
    }

    @Test
    void checkUserInputIsStrike() {
        Application.initCommonMessageMap();
        Application.computerNumber = List.of('1', '2', '3');
        String strike = "123";
        String noStrike = "321";

        boolean strikeFlag = Application.checkUserInputIsThreeStrike(strike);
        boolean noStrikeFlag = Application.checkUserInputIsThreeStrike(noStrike);

        Assertions.assertThat(strikeFlag).isTrue();
        Assertions.assertThat(noStrikeFlag).isFalse();
    }
}
