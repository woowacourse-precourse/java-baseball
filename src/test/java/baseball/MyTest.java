package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {

    @Test
    void computerNumberSizeTest() {
        //given(준비)
        Application.initComputerNumber();

        //when(실행)
        List<Character> computerNumber = Application.computerNumber;

        //then(검증)
        Assertions.assertThat(computerNumber).size().isEqualTo(3);
    }

    @Test
    void computerNumberRangeTest() {
        //given(준비)
        Application.initComputerNumber();

        //when(실행)
        List<Character> computerNumber = Application.computerNumber;

        //then(검증)
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(computerNumber.get(i)).isBetween('1', '9');
        }
    }

    @Test
    void checkStrike() {
        //given(준비)
        Application.computerNumber = List.of('1', '2', '3');

        //when(실행)
        int strikeCount = Application.checkStrike("456");

        //then(검증)
        Assertions.assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void checkBall() {
        //given(준비)
        Application.computerNumber = List.of('1', '2', '3');

        //when(실행)
        int ballCount = Application.checkBall("312");

        //then(검증)
        Assertions.assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void checkNothing() {
        //given(준비)
        Application.computerNumber = List.of('1', '2', '3');

        //when(실행)
        boolean nothingFlag = Application.checkNothing("456");

        //then(검증)
        Assertions.assertThat(nothingFlag).isTrue();
    }


    @Test
    void validateUserInputSize() {
        //given(준비)
        String userInput = "1234";

        //when(실행)

        //then(검증)
        try {
            Application.validateUserInputSize(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void validateUserInputForm() {
        //given(준비)
        String userInput = "ABC";

        //when(실행)

        //then(검증)
        try {
            Application.validateUserInputSize(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Test
    void giveHint() {
        //given(준비)
        Application.computerNumber = List.of('1', '2', '3');
        String userInput_one = "132";
        String userInput_two = "123";
        String userInput_three = "456";
        String userInput_four = "431";

        //when(실행)
        String hintMessage_one = Application.giveHint(userInput_one);
        String hintMessage_two = Application.giveHint(userInput_two);
        String hintMessage_three = Application.giveHint(userInput_three);
        String hintMessage_four = Application.giveHint(userInput_four);

        //then(검증)
        Assertions.assertThat(hintMessage_one).isEqualTo("2볼 1스트라이크");
        Assertions.assertThat(hintMessage_two).isEqualTo("3스트라이크");
        Assertions.assertThat(hintMessage_three).isEqualTo("낫싱");
        Assertions.assertThat(hintMessage_four).isEqualTo("2볼 ");
    }

    @Test
    void checkUserInputIsStrike() {
        //given(준비)
        Application.initCommonMessageMap();
        Application.computerNumber = List.of('1','2','3');
        String strike = "123";
        String noStrike = "321";

        //when(실행)
        boolean firstFlag = Application.checkUserInputIsThreeStrike(strike);
        boolean secondFlag = Application.checkUserInputIsThreeStrike(noStrike);

        //then(검증)
        Assertions.assertThat(firstFlag).isTrue();
        Assertions.assertThat(secondFlag).isFalse();
    }
}
